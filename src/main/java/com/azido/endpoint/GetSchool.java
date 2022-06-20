package com.azido.endpoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.Converter.ModelConverter;
import com.azido.dao.DistrictDAO;
import com.azido.dao.SchoolDAO;
import com.azido.dynamodb.models.District;
import com.azido.dynamodb.models.School;
import com.azido.exceptions.DistrictNotFoundException;
import com.azido.exceptions.SchoolNotFoundException;
import com.azido.models.DistrictModel;
import com.azido.models.Request.GetDistrictRequest;
import com.azido.models.Request.GetSchoolRequest;
import com.azido.models.Result.GetDistrictResult;
import com.azido.models.Result.GetSchoolResult;
import com.azido.models.SchoolModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetSchool implements RequestHandler<GetSchoolRequest, GetSchoolResult> {
    private final Logger log = LogManager.getLogger();
    private final SchoolDAO schoolDAO;


    @Inject
    public GetSchool(SchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }

    @Override
    public GetSchoolResult handleRequest(GetSchoolRequest getSchoolRequest, Context context) {
        log.info("Received GetDistrictRequest {}", getSchoolRequest);

        School school = schoolDAO.getSchool(getSchoolRequest.getDistrictId(), getSchoolRequest.getId());

        if (school == null) {
            throw new SchoolNotFoundException();
        }

        SchoolModel schoolModel = new ModelConverter().toSchoolModel(school);

        return GetSchoolResult.builder()
                .withSchoolModel(schoolModel)
                .build();
    }
}