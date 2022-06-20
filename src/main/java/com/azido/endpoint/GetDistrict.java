package com.azido.endpoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.Converter.ModelConverter;
import com.azido.dao.AssignmentDAO;
import com.azido.dao.DistrictDAO;
import com.azido.dynamodb.models.Assignment;
import com.azido.dynamodb.models.District;
import com.azido.exceptions.AssignmentNotFoundException;
import com.azido.exceptions.DistrictNotFoundException;
import com.azido.models.AssignmentModel;
import com.azido.models.DistrictModel;
import com.azido.models.Request.GetAssignmentRequest;
import com.azido.models.Request.GetDistrictRequest;
import com.azido.models.Result.GetAssignmentResult;
import com.azido.models.Result.GetDistrictResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetDistrict implements RequestHandler<GetDistrictRequest, GetDistrictResult> {
    private final Logger log = LogManager.getLogger();
    private final DistrictDAO districtDao;


    @Inject
    public GetDistrict(DistrictDAO districtDao) {
        this.districtDao = districtDao;
    }

    @Override
    public GetDistrictResult handleRequest(GetDistrictRequest getDistrictRequest, Context context) {
        log.info("Received GetDistrictRequest {}", getDistrictRequest);

        District district = districtDao.getDistrict(getDistrictRequest.getId());

        if (district == null) {
            throw new DistrictNotFoundException();
        }

        DistrictModel districtModel = new ModelConverter().toDistrictModel(district);

        return GetDistrictResult.builder()
                .withDistrictModel(districtModel)
                .build();
    }
}
