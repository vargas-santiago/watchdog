package com.azido.models.Request;

public class GetAssignmentRequest {
    private String id;
    private String studentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetAssignmentRequest that = (GetAssignmentRequest) o;

        if (!id.equals(that.id)) return false;
        return studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + studentId.hashCode();
        return result;
    }

    public GetAssignmentRequest(String id, String studentId) {
        this.id = id;
        this.studentId = studentId;
    }

    public GetAssignmentRequest() {}

    public GetAssignmentRequest(Builder builder) {
        this.id = builder.id;
        this.studentId = builder.studentId;
    }


    public static final class Builder {
        private String id;
        private String studentId;

        private Builder() {

        }

        public Builder withId(String IdToUse) {
            this.id = IdToUse;
            return this;
        }

        public Builder withStudentId(String studentIdToUse) {
            this.studentId = studentIdToUse;
            return this;
        }


    }
}