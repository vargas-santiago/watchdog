package com.azido.models.Request;

public class GetStudentRequest {

    private String schoolId;
    private String id;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
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

        GetStudentRequest that = (GetStudentRequest) o;

        if (!schoolId.equals(that.schoolId)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        int result = schoolId.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }

    public GetStudentRequest() {}

    public GetStudentRequest(Builder builder) {
        this.schoolId = builder.schoolId;
        this.id = builder.id;
    }


    public static final class Builder {
        private String schoolId;
        private String id;

        public Builder withId(String IdToUse) {
            this.id = IdToUse;
            return this;
        }

        public Builder withSchoolId(String schoolId) {
            this.schoolId = schoolId;
            return this;
        }

        public GetStudentRequest build() {
            return new GetStudentRequest(this);
        }
    }
}
