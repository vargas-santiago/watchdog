package com.azido.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "assignments")
public class Assignment {

    private String id;
    private String studentId;
    private String title;
    private int studentScore;
    private int maxScore;
    private String notes;

    @Override
    public String toString() {
        return "Assignment{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", title='" + title + '\'' +
                ", studentScore=" + studentScore +
                ", maxScore=" + maxScore +
                ", notes='" + notes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assignment that = (Assignment) o;

        if (!id.equals(that.id)) return false;
        return studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + studentId.hashCode();
        return result;
    }

    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    @DynamoDBRangeKey(attributeName = "studentId")
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    @DynamoDBAttribute(attributeName = "title")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    @DynamoDBAttribute(attributeName = "studentScore")
    public int getStudentScore() {
        return studentScore;
    }
    public void setStudentScore(int studentScore) {
        this.studentScore = studentScore;
    }


    @DynamoDBAttribute(attributeName = "maxScore")
    public int getMaxScore() {
        return maxScore;
    }
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }


    @DynamoDBAttribute(attributeName = "notes")
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
