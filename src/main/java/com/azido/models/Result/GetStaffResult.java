package com.azido.models.Result;

import com.azido.models.StaffModel;

public class GetStaffResult {
    private StaffModel staffModel;

    public GetStaffResult(Builder builder) {
        this.staffModel = builder.staffModel;
    }

    public StaffModel getStaffModel() {
        return staffModel;
    }

    public void setStaffModel(StaffModel staffModel) {
        this.staffModel = staffModel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private StaffModel staffModel;

        public Builder withStaffModel(StaffModel staffModel) {
            this.staffModel = staffModel;
            return this;
        }

        public GetStaffResult build() {
            return new GetStaffResult(this);
        }
    }
}
