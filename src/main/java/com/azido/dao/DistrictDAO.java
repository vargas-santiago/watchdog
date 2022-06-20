package com.azido.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.azido.dynamodb.models.District;
import com.azido.exceptions.DistrictNotFoundException;

import javax.inject.Inject;

public class DistrictDAO {
    private final DynamoDBMapper dynamoDbMapper;

    @Inject
    public DistrictDAO(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    public District getDistrict(String districtId) {
        District district = this.dynamoDbMapper.load(District.class, districtId);

        if (district == null) {
            throw new DistrictNotFoundException("No district found with id: " + districtId);
        }

        return district;
    }


    public District saveDistrict(District district) {
        this.dynamoDbMapper.save(district);
        return district;
    }

    public District deleteDistrict(District district) {
        this.dynamoDbMapper.delete(district);
        return district;
    }


    public boolean doesDistrictExist(String districtId) {
        District district = this.dynamoDbMapper.load(District.class, districtId);

        if (district == null) {
            return false;
        }
        return true;
    }
}
