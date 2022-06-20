package com.azido.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "classes")
public class ClassObject {

    private String studentId;
    private String id;
    private String name;
    private String subject;
    private List<String> assignments;

    @Override
    public String toString() {
        return "Class{" +
                "studentId='" + studentId + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", assignments=" + assignments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassObject aClass = (ClassObject) o;

        return id.equals(aClass.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @DynamoDBHashKey(attributeName = "studentId")
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @DynamoDBRangeKey(attributeName = "id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @DynamoDBAttribute(attributeName = "subject")
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }


    @DynamoDBAttribute(attributeName = "assignments")
    public List<String> getAssignments() {
        return assignments;
    }
    public void setAssignments(List<String> assignments) {
        this.assignments = assignments;
    }
}
