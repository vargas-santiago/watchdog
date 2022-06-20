package com.azido.models;

import com.azido.dynamodb.models.District;

public class DistrictModel {
    private String id;


    public DistrictModel(Builder builder) {
        this.id = builder.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DistrictModel that = (DistrictModel) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DistrictModel{" +
                "id='" + id + '\'' +
                '}';
    }

    public District toDistrict() {
        District district = new District();
        district.setId(id);
        return district;
    }

    public DistrictModel() {}

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;

        public Builder withId(String IdToUse) {
            this.id = IdToUse;
            return this;
        }

        public DistrictModel build() {
            return new DistrictModel(this);
        }
    }
}
