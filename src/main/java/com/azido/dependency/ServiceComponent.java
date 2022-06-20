package com.azido.dependency;

import com.azido.endpoint.*;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = DaoModule.class)
@Singleton
public interface ServiceComponent {
    AddAssignment provideAddAssignment();
    AddClass provideAddClass();
    DeleteAssignment provideDeleteAssignment();
    DeleteClass provideDeleteClass();
    GetAssignment provideGetAssignment();
    GetClass provideGetClass();
    GetDistrict provideGetDistrict();
    GetSchool provideGetSchool();
    GetStaff provideGetStaff();
    GetStudent provideGetStudent();
    UpdateAssignment provideUpdateAssignment();
    UpdateClass provideUpdateClass();
    UpdateSchool provideUpdateSchool();
    UpdateStaff provideUpdateStaff();
    UpdateStudent provideUpdateStudent();
}
