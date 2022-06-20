package com.azido.models.Request;

import java.util.List;

public class AddClassRequest {

    private String studentId;
    private String id;
    private String name;
    private String subject;
    private List<String> assignments;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<String> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<String> assignments) {
        this.assignments = assignments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddClassRequest that = (AddClassRequest) o;

        if (!id.equals(that.id)) return false;
        return studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + studentId.hashCode();
        return result;
    }

    public AddClassRequest(String id, String studentId) {
        this.id = id;
        this.studentId = studentId;
    }

    public AddClassRequest() {}

    public AddClassRequest(Builder builder) {
        this.id = builder.id;
        this.studentId = builder.studentId;
        this.name = builder.name;
        this.subject = builder.subject;
        this.assignments = builder.assignments;
    }


    public static final class Builder {
        private String studentId;
        private String id;
        private String name;
        private String subject;
        private List<String> assignments;

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

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder withAssignments(List<String> assignments) {
            this.assignments = assignments;
            return this;
        }

        public AddClassRequest build() {
            return new AddClassRequest(this);
        }
    }
}
