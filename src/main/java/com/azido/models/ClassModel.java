package com.azido.models;

import com.azido.dynamodb.models.Assignment;
import com.azido.dynamodb.models.ClassObject;

import java.util.List;

public class ClassModel {
    private String studentId;
    private String id;
    private String name;
    private String subject;
    private List<String> assignments;

    public ClassModel(Builder builder) {
        this.id = builder.id;
        this.studentId = builder.studentId;
        this.name = builder.name;
        this.subject = builder.subject;
        this.assignments = builder.assignments;
    }

    public ClassObject toClass() {
        ClassObject classObject = new ClassObject();
        classObject.setId(id);
        classObject.setStudentId(studentId);
        classObject.setName(name);
        classObject.setSubject(subject);
        classObject.setAssignments(assignments);
        return classObject;
    }

    public ClassModel() {}

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

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String studentId;
        private String id;
        private String name;
        private String subject;
        private List<String> assignments;

        public Builder withId(String IdToUse) {
            this.id = IdToUse;
            return this;
        }

        public Builder withStudentId(String studentIdToUse) {
            this.studentId = studentIdToUse;
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

        public ClassModel build() {
            return new ClassModel(this);
        }
    }
}
