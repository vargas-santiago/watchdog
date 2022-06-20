package com.azido.models.Result;

import com.azido.models.SchoolModel;
import com.azido.models.StaffModel;

public class GetSchoolResult {
    private SchoolModel schoolModel;

    public GetSchoolResult(Builder builder) {
        this.schoolModel = builder.schoolModel;
    }

    public SchoolModel get() {
        return schoolModel;
    }

    public void setStaffModel(SchoolModel staffModel) {
        this.schoolModel = schoolModel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private SchoolModel schoolModel;

        public Builder withSchoolModel(SchoolModel schoolModel) {
            this.schoolModel = schoolModel;
            return this;
        }

        public GetSchoolResult build() {
            return new GetSchoolResult(this);
        }
    }
}
