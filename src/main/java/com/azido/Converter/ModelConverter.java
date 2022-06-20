package com.azido.Converter;

import com.azido.dynamodb.models.*;
import com.azido.models.*;

public class ModelConverter {

    public AssignmentModel toAssignmentModel(Assignment assignment) {
        return AssignmentModel.builder()
                .withId(assignment.getId())
                .withMaxScore(assignment.getMaxScore())
                .withNotes(assignment.getNotes())
                .withStudentId(assignment.getStudentId())
                .withStudentScore(assignment.getStudentScore())
                .withTitle(assignment.getTitle())
                .build();
    }

    public DistrictModel toDistrictModel(District district) {
        return DistrictModel.builder()
                .withId(district.getId())
                .build();
    }

    public ClassModel toClassModel(ClassObject classObject) {
        return ClassModel.builder()
                .withId(classObject.getId())
                .withStudentId(classObject.getStudentId())
                .withAssignments(classObject.getAssignments())
                .withName(classObject.getName())
                .withSubject(classObject.getSubject())
                .build();
    }

    public StaffModel toStaffModel(Staff staff) {
        return StaffModel.builder()
                .withId(staff.getId())
                .withSchoolId(staff.getSchoolId())
                .withAddress(staff.getAddress())
                .withSalary(staff.getSalary())
                .withGender(staff.getGender())
                .withPhoneNumber(staff.getPhoneNumber())
                .withFirstName(staff.getFirstName())
                .withMiddleName(staff.getMiddleName())
                .withLastName(staff.getLastName())
                .withEmail(staff.getEmail())
                .build();
    }

    public StudentModel toStudentModel(Student student) {
        return StudentModel.builder()
                .withId(student.getId())
                .withSchoolId(student.getSchoolId())
                .withAddress(student.getAddress())
                .withGender(student.getGender())
                .withFirstName(student.getFirstName())
                .withMiddleName(student.getMiddleName())
                .withLastName(student.getLastName())
                .withEmail(student.getEmail())
                .build();
    }

    public SchoolModel toSchoolModel(School school) {
        return SchoolModel.builder()
                .withId(school.getId())
                .withDistrictId(school.getDistrictId())
                .withName(school.getName())
                .withSchoolType(school.getSchoolType())
                .build();
    }


}
