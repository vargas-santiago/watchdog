package com.azido.models;

import com.azido.dynamodb.models.Assignment;
import com.azido.dynamodb.models.District;

public class AssignmentModel {
    private String id;
    private String studentId;
    private String title;
    private int studentScore;
    private int maxScore;
    private String notes;

    public AssignmentModel(Builder builder) {
        this.id = builder.id;
        this.studentId = builder.studentId;
        this.title = builder.title;
        this.studentScore = builder.studentScore;
        this.maxScore = builder.maxScore;
        this.notes = builder.notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssignmentModel that = (AssignmentModel) o;

        if (studentScore != that.studentScore) return false;
        if (maxScore != that.maxScore) return false;
        if (!id.equals(that.id)) return false;
        if (!studentId.equals(that.studentId)) return false;
        if (!title.equals(that.title)) return false;
        return notes.equals(that.notes);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + studentId.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + studentScore;
        result = 31 * result + maxScore;
        result = 31 * result + notes.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AssignmentModel{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", title='" + title + '\'' +
                ", studentScore=" + studentScore +
                ", maxScore=" + maxScore +
                ", notes='" + notes + '\'' +
                '}';
    }

    public Assignment toAssignment() {
        Assignment assignment = new Assignment();
        assignment.setId(id);
        assignment.setStudentId(studentId);
        assignment.setTitle(title);
        assignment.setStudentScore(studentScore);
        assignment.setMaxScore(maxScore);
        assignment.setNotes(notes);
        return assignment;
    }

    public AssignmentModel() {}

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


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public int getStudentScore() {
        return studentScore;
    }
    public void setStudentScore(int studentScore) {
        this.studentScore = studentScore;
    }


    public int getMaxScore() {
        return maxScore;
    }
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }


    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String studentId;
        private String title;
        private int studentScore;
        private int maxScore;
        private String notes;

        public Builder withId(String IdToUse) {
            this.id = IdToUse;
            return this;
        }

        public Builder withStudentId(String studentIdToUse) {
            this.studentId = studentIdToUse;
            return this;
        }

        public Builder withTitle(String titleToUse) {
            this.title = titleToUse;
            return this;
        }

        public Builder withStudentScore(int studentScoreToUse) {
            this.studentScore = studentScoreToUse;
            return this;
        }

        public Builder withMaxScore(int maxScoreToUse) {
            this.maxScore = maxScoreToUse;
            return this;
        }

        public Builder withNotes(String notesToUse) {
            this.notes = notesToUse;
            return this;
        }

        public AssignmentModel build() {
            return new AssignmentModel(this);
        }
    }
}
