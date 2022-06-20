package com.azido.models.Request;

public class UpdateSchoolRequest {

    private String districtId;
    private String id;
    private String name;
    private int schoolType;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateSchoolRequest that = (UpdateSchoolRequest) o;

        if (!id.equals(that.id)) return false;
        return districtId.equals(that.districtId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + districtId.hashCode();
        return result;
    }

    public UpdateSchoolRequest(String id, String studentId) {
        this.id = id;
        this.districtId = studentId;
    }

    public UpdateSchoolRequest() {}

    public UpdateSchoolRequest(Builder builder) {
        this.id = builder.id;
        this.districtId = builder.districtId;
        this.name = builder.name;
        this.schoolType = builder.schoolType;
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

        public UpdateSchoolRequest build() {
            return new UpdateSchoolRequest(this);
        }
    }
}
