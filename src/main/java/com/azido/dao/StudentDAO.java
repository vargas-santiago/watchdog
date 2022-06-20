package com.azido.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.azido.dynamodb.models.Student;
import com.azido.exceptions.StudentNotFoundException;

import javax.inject.Inject;

public class StudentDAO {
    private final DynamoDBMapper dynamoDbMapper;

    @Inject
    public StudentDAO(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }
    public Student getStudent(String schoolId, String studentId) {
        Student student = this.dynamoDbMapper.load(Student.class, schoolId, studentId);

        if (student == null) {
            throw new StudentNotFoundException("No student found with id: " + studentId);
        }

        return student;
    }


    public Student saveStudent(Student student) {
        this.dynamoDbMapper.save(student);
        return student;
    }

    public Student deleteStudent(Student student) {
        this.dynamoDbMapper.delete(student);
        return student;
    }


    public boolean doesStudentExist(String schoolId, String studentId) {
        Student student = this.dynamoDbMapper.load(Student.class, schoolId, studentId);

        if (student == null) {
            return false;
        }
        return true;
    }
}
