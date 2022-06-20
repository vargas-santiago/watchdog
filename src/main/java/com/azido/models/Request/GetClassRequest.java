package com.azido.models.Request;

import java.util.List;

public class GetClassRequest {

    private String studentId;
    private String id;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetClassRequest that = (GetClassRequest) o;

        if (!id.equals(that.id)) return false;
        return studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + studentId.hashCode();
        return result;
    }

    public GetClassRequest(String id, String studentId) {
        this.id = id;
        this.studentId = studentId;
    }

    public GetClassRequest() {}

    public GetClassRequest(Builder builder) {
        this.id = builder.id;
        this.studentId = builder.studentId;
    }


    public static final class Builder {
        private String studentId;
        private String id;

        private Builder() {

        }

        public Builder withId(String IdToUse) {
            this.id = IdToUse;
            return this;
        }

        public Builder withStudentId(String IdToUse) {
            this.studentId = studentId;
            return this;
        }

        public GetClassRequest build() {
            return new GetClassRequest(this);
        }
    }
}
