package com.azido.models.Request;

public class UpdateStudentRequest {

    private String schoolId;
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String email;
    private String address;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateStudentRequest that = (UpdateStudentRequest) o;

        if (!id.equals(that.id)) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!middleName.equals(that.middleName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!gender.equals(that.gender)) return false;
        if (!email.equals(that.email)) return false;
        if (!address.equals(that.address)) return false;
        return schoolId.equals(that.schoolId);
    }

    @Override
    public String toString() {
        return "AddStaffRequest{" +
                "schoolId='" + schoolId + '\'' +
                ", id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = schoolId.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    public UpdateStudentRequest() {}

    public UpdateStudentRequest(Builder builder) {
        this.schoolId = builder.schoolId;
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.email = builder.email;
        this.address = builder.address;
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

        public UpdateStudentRequest build() {
            return new UpdateStudentRequest(this);
        }
    }
}
