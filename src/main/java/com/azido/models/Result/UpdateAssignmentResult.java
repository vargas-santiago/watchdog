package com.azido.models.Result;

import com.azido.models.AssignmentModel;

public class UpdateAssignmentResult {
    private AssignmentModel assignmentModel;

    public UpdateAssignmentResult(Builder builder) {
        this.assignmentModel = builder.assignmentModel;
    }

    public AssignmentModel getAssignmentModel() {
        return assignmentModel;
    }

    public void setAssignmentModel(AssignmentModel assignmentModel) {
        this.assignmentModel = assignmentModel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private AssignmentModel assignmentModel;

        public Builder withAssignmentModel(AssignmentModel assignmentModel) {
            this.assignmentModel = assignmentModel;
            return this;
        }

        public UpdateAssignmentResult build() {
            return new UpdateAssignmentResult(this);
        }
    }
}
