package com.azido.models.Result;

import com.azido.models.StaffModel;

public class UpdateStaffResult {
    private StaffModel staffModel;

    public UpdateStaffResult(Builder builder) {
        this.staffModel = builder.staffModel;
    }

    public StaffModel getAssignmentModel() {
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

        public UpdateStaffResult build() {
            return new UpdateStaffResult(this);
        }
    }
}
