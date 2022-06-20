package com.azido.models.Request;

public class GetDistrictRequest {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetDistrictRequest that = (GetDistrictRequest) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        return result;
    }

    public GetDistrictRequest(String id) {
        this.id = id;
    }

    public GetDistrictRequest() {}

    public GetDistrictRequest(Builder builder) {
        this.id = builder.id;
    }


    public static final class Builder {
        private String id;

        private Builder() {

        }

        public Builder withId(String IdToUse) {
            this.id = IdToUse;
            return this;
        }

    }
}