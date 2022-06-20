package com.azido.models.Result;

import com.azido.models.SchoolModel;

public class UpdateSchoolResult {
    private SchoolModel schoolModel;

    public UpdateSchoolResult(Builder builder) {
        this.schoolModel = builder.schoolModel;
    }

    public SchoolModel get() {
        return schoolModel;
    }

    public void setSchoolModel(SchoolModel staffModel) {
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

        public UpdateSchoolResult build() {
            return new UpdateSchoolResult(this);
        }
    }
}
