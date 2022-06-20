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
import com.azido.models.Request.UpdateAssignmentRequest;
import com.azido.models.Request.UpdateStaffRequest;
import com.azido.models.Result.UpdateAssignmentResult;
import com.azido.models.Result.UpdateStaffResult;
import com.azido.models.StaffModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateStaff implements RequestHandler<UpdateStaffRequest, UpdateStaffResult> {
    private final Logger log = LogManager.getLogger();
    private final StaffDao staffDao;


    @Inject
    public UpdateStaff(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public UpdateStaffResult handleRequest(UpdateStaffRequest updateStaffRequest, Context context) {
        log.info("Received UpdateStaffRequest {}", updateStaffRequest);

        Staff staff = staffDao.getStaff(updateStaffRequest.getSchoolId(), updateStaffRequest.getId());

        if (staff == null) {
            throw new StaffNotFoundException();
        }

        staff.setId(updateStaffRequest.getId());
        staff.setAddress(updateStaffRequest.getAddress());
        staff.setEmail(updateStaffRequest.getEmail());
        staff.setGender(updateStaffRequest.getGender());
        staff.setFirstName(updateStaffRequest.getFirstName());
        staff.setMiddleName(updateStaffRequest.getMiddleName());
        staff.setLastName(updateStaffRequest.getLastName());
        staff.setPhoneNumber(updateStaffRequest.getPhoneNumber());
        staff.setSchoolId(updateStaffRequest.getSchoolId());

        this.staffDao.saveStaff(staff);

        StaffModel staffModel = new ModelConverter().toStaffModel(staff);

        return UpdateStaffResult.builder()
                .withStaffModel(staffModel)
                .build();
    }
}
