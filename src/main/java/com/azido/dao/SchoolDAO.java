package com.azido.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.azido.dynamodb.models.School;
import com.azido.exceptions.SchoolNotFoundException;

import javax.inject.Inject;

public class SchoolDAO {

    private final DynamoDBMapper dynamoDbMapper;

    @Inject
    public SchoolDAO(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    public School getSchool(String districtId, String schoolId) {
        School school = this.dynamoDbMapper.load(School.class, schoolId);

        if (school == null) {
            throw new SchoolNotFoundException("No school found with id: " + schoolId);
        }

        return school;
    }


    public School saveSchool(School school) {
        this.dynamoDbMapper.save(school);
        return school;
    }

    public School deleteSchool(School school) {
        this.dynamoDbMapper.delete(school);
        return school;
    }


    public boolean doesSchoolExist(String districtId, String schoolId) {
        School district = this.dynamoDbMapper.load(School.class, districtId, schoolId);

        if (district == null) {
            return false;
        }
        return true;
    }
}
