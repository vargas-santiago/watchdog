package com.azido.models;

public class StudentModel {
    private String schoolId;
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String email;
    private String address;

    public StudentModel(Builder builder) {
        this.schoolId = builder.schoolId;
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.email = builder.email;
        this.address = builder.address;
    }

    public StudentModel() {}

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getSchoolId() {
        return schoolId;
    }
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String schoolId;
        private String id;
        private String firstName;
        private String middleName;
        private String lastName;
        private String gender;
        private String email;
        private String address;

        public Builder withId(String IdToUse) {
            this.id = IdToUse;
            return this;
        }

        public Builder withSchoolId(String schoolId) {
            this.schoolId = schoolId;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withGender (String gender) {
            this.gender = gender;
            return this;
        }

        public Builder withEmail (String email) {
            this.email = email;
            return this;
        }

        public Builder withAddress (String address) {
            this.address = address;
            return this;
        }



        public StudentModel build() {
            return new StudentModel(this);
        }
    }
}
