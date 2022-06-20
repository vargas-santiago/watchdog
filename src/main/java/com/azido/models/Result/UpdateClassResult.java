package com.azido.models.Result;

import com.azido.models.ClassModel;

public class UpdateClassResult {
    private ClassModel classModel;

    public UpdateClassResult(Builder builder) {
        this.classModel = builder.classModel;
    }

    public ClassModel getClassModel() {
        return classModel;
    }

    public void setClassModel(ClassModel classModel) {
        this.classModel = classModel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private ClassModel classModel;

        public Builder withClassModel(ClassModel classModel) {
            this.classModel = classModel;
            return this;
        }

        public UpdateClassResult build() {
            return new UpdateClassResult(this);
        }
    }
}
