package com.azido.models.Request;

public class GetSchoolRequest {

    private String districtId;
    private String id;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetSchoolRequest that = (GetSchoolRequest) o;

        if (!id.equals(that.id)) return false;
        return districtId.equals(that.districtId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + districtId.hashCode();
        return result;
    }

    public GetSchoolRequest(String id, String studentId) {
        this.id = id;
        this.districtId = studentId;
    }

    public GetSchoolRequest() {}

    public GetSchoolRequest(Builder builder) {
        this.id = builder.id;
        this.districtId = builder.districtId;
    }


    public static final class Builder {
        private String districtId;
        private String id;


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

        public GetSchoolRequest build() {
            return new GetSchoolRequest(this);
        }
    }
}
