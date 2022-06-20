package com.azido.models.Result;

import com.azido.models.AssignmentModel;
import com.azido.models.DistrictModel;

public class GetDistrictResult {
    private DistrictModel districtModel;

    public GetDistrictResult(Builder builder) {
        this.districtModel = builder.districtModel;
    }

    public DistrictModel getDistrictModel() {
        return districtModel;
    }

    public void setDistrictModel(DistrictModel districtModel) {
        this.districtModel = districtModel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private DistrictModel districtModel;

        public Builder withDistrictModel(DistrictModel districtModel) {
            this.districtModel = districtModel;
            return this;
        }

        public GetDistrictResult build() {
            return new GetDistrictResult(this);
        }
    }
}
