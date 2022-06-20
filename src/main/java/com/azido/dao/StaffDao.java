package com.azido.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.azido.dynamodb.models.Staff;
import com.azido.exceptions.StaffNotFoundException;

import javax.inject.Inject;

public class StaffDao {
    private final DynamoDBMapper dynamoDbMapper;

    @Inject
    public StaffDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    public Staff getStaff(String schoolId, String staffId) {
        Staff staff = this.dynamoDbMapper.load(Staff.class, schoolId, staffId);

        if (staff == null) {
            throw new StaffNotFoundException("No staff found with id: " + staffId);
        }

        return staff;
    }


    public Staff saveStaff(Staff staff) {
        this.dynamoDbMapper.save(staff);
        return staff;
    }

    public Staff deleteStaff(Staff staff) {
        this.dynamoDbMapper.delete(staff);
        return staff;
    }


    public boolean doesStaffExist(String schoolId, String staffId) {
        Staff staff = this.dynamoDbMapper.load(Staff.class, schoolId, staffId);

        if (staff == null) {
            return false;
        }
        return true;
    }
}
