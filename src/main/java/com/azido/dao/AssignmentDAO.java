package com.azido.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.azido.dynamodb.models.Assignment;
import com.azido.exceptions.AssignmentNotFoundException;
import com.azido.exceptions.ClassNotFoundException;

import javax.inject.Inject;

public class AssignmentDAO {
    private final DynamoDBMapper dynamoDbMapper;

    @Inject
    public AssignmentDAO(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }
    public Assignment getAssignment(String assignmentId, String studentId) {
        Assignment assignment = this.dynamoDbMapper.load(Assignment.class, assignmentId, studentId);

        if (assignment == null) {
            throw new AssignmentNotFoundException("No assignment found with id: " + assignmentId);
        }

        return assignment;
    }


    public Assignment saveAssignment(Assignment assignment) {
        this.dynamoDbMapper.save(assignment);
        return assignment;
    }

    public Assignment deleteAssignment(Assignment assignment) {
        this.dynamoDbMapper.delete(assignment);
        return assignment;
    }


    public boolean doesAssignmentExist(String assignmentId, String studentId) {
        Assignment assignment = this.dynamoDbMapper.load(Assignment.class, assignmentId, studentId);

        if (assignment == null) {
            return false;
        }
        return true;
    }
}
