package com.azido.endpoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.Converter.ModelConverter;
import com.azido.dao.AssignmentDAO;
import com.azido.dao.StaffDao;
import com.azido.dynamodb.models.Assignment;
import com.azido.dynamodb.models.Staff;
import com.azido.exceptions.AssignmentNotFoundException;
import com.azido.exceptions.StaffNotFoundException;
import com.azido.models.AssignmentModel;
import com.azido.models.Request.GetAssignmentRequest;
import com.azido.models.Request.GetStaffRequest;
import com.azido.models.Result.GetAssignmentResult;
import com.azido.models.Result.GetStaffResult;
import com.azido.models.StaffModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetStaff implements RequestHandler<GetStaffRequest, GetStaffResult> {
    private final Logger log = LogManager.getLogger();
    private final StaffDao staffDao;


    @Inject
    public GetStaff(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public GetStaffResult handleRequest(GetStaffRequest getStaffRequest , Context context) {
        log.info("Received GetStaffRequest {}", getStaffRequest);

        Staff staff = staffDao.getStaff(getStaffRequest.getSchoolId(), getStaffRequest.getId());

        if (staff == null) {
            throw new StaffNotFoundException();
        }

        StaffModel staffModel = new ModelConverter().toStaffModel(staff);

        return GetStaffResult.builder()
                .withStaffModel(staffModel)
                .build();
    }
}
