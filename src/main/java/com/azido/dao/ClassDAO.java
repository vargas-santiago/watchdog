package com.azido.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.azido.dynamodb.models.ClassObject;
import com.azido.exceptions.ClassNotFoundException;

import javax.inject.Inject;

public class ClassDAO {
    private final DynamoDBMapper dynamoDbMapper;

    @Inject
    public ClassDAO(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }
    public ClassObject getClass(String studentId, String classId) {
        ClassObject student = this.dynamoDbMapper.load(ClassObject.class, studentId, classId);

        if (student == null) {
            throw new ClassNotFoundException("No class found with id: " + classId);
        }

        return student;
    }


    public ClassObject saveClass(ClassObject classObject) {
        this.dynamoDbMapper.save(classObject);
        return classObject;
    }

    public ClassObject deleteClass(ClassObject classObject) {
        this.dynamoDbMapper.delete(classObject);
        return classObject;
    }


    public boolean doesClassExist(String studentId, String classId) {
        ClassObject classObject = this.dynamoDbMapper.load(ClassObject.class, studentId, classId);

        if (classObject == null) {
            return false;
        }
        return true;
    }
}
