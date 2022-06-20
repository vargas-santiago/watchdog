package com.azido.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "schools")
public class School {

    private String districtId;
    private String id;
    private String name;
    private int schoolType;

    @Override
    public String toString() {
        return "School{" +
                "districtId='" + districtId + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", schoolType=" + schoolType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        School school = (School) o;

        return id.equals(school.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @DynamoDBHashKey(attributeName = "districtId")
    public String getDistrictId() {
        return districtId;
    }
    public void setDistrictId(String districtId) {
        this.districtId = districtId;
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


    @DynamoDBAttribute(attributeName = "schoolType")
    public int getSchoolType() {
        return schoolType;
    }
    public void setSchoolType(int schoolType) {
        this.schoolType = schoolType;
    }
}
