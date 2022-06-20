package com.azido.endpoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.Converter.ModelConverter;
import com.azido.dao.SchoolDAO;
import com.azido.dynamodb.models.School;
import com.azido.exceptions.SchoolNotFoundException;
import com.azido.models.Request.UpdateSchoolRequest;
import com.azido.models.Result.UpdateSchoolResult;
import com.azido.models.SchoolModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateSchool implements RequestHandler<UpdateSchoolRequest, UpdateSchoolResult> {
    private final Logger log = LogManager.getLogger();
    private final SchoolDAO schoolDAO;


    @Inject
    public UpdateSchool(SchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }

    @Override
    public UpdateSchoolResult handleRequest(UpdateSchoolRequest updateSchoolRequest, Context context) {
        log.info("Received UpdateStaffRequest {}", updateSchoolRequest);

        School school = schoolDAO.getSchool(updateSchoolRequest.getDistrictId(), updateSchoolRequest.getId());

        if (school == null) {
            throw new SchoolNotFoundException();
        }

        school.setId(updateSchoolRequest.getId());
        school.setSchoolType(updateSchoolRequest.getSchoolType());
        school.setDistrictId(updateSchoolRequest.getDistrictId());
        school.setName(updateSchoolRequest.getName());

        this.schoolDAO.saveSchool(school);

        SchoolModel schoolModel = new ModelConverter().toSchoolModel(school);

        return UpdateSchoolResult.builder()
                .withSchoolModel(schoolModel)
                .build();
    }
}
