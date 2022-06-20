package com.azido.models;

import com.azido.models.Request.UpdateSchoolRequest;

public class SchoolModel {
    private String districtId;
    private String id;
    private String name;
    private int schoolType;

    public SchoolModel(Builder builder) {
        this.districtId = builder.districtId;
        this.id = builder.id;
        this.name = builder.name;
        this.schoolType = builder.schoolType;
    }

    public SchoolModel() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = name;
    }

    public int getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(int schoolType) {
        this.schoolType = schoolType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String districtId;
        private String id;
        private String name;
        private int schoolType;


        private Builder() {

        }

        public Builder withId(String IdToUse) {
            this.id = IdToUse;
            return this;
        }

        public Builder withDistrictId(String districtId) {
            this.districtId = districtId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSchoolType(int schoolType) {
            this.schoolType = schoolType;
            return this;
        }



        public SchoolModel build() {
            return new SchoolModel(this);
        }
    }
}
