package com.azido.models.Result;

import com.azido.models.StudentModel;

public class UpdateStudentResult {
    private StudentModel studentModel;

    public UpdateStudentResult(Builder builder) {
        this.studentModel = builder.studentModel;
    }

    public StudentModel getStudentModel() {
        return studentModel;
    }

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private StudentModel studentModel;

        public Builder withStudentModel(StudentModel studentModel) {
            this.studentModel = studentModel;
            return this;
        }

        public UpdateStudentResult build() {
            return new UpdateStudentResult(this);
        }
    }
}
