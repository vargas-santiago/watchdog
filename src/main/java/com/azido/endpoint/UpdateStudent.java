package com.azido.endpoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.Converter.ModelConverter;
import com.azido.dao.StudentDAO;
import com.azido.dynamodb.models.Student;
import com.azido.exceptions.StudentNotFoundException;
import com.azido.models.Request.UpdateStudentRequest;
import com.azido.models.Result.UpdateStudentResult;
import com.azido.models.StudentModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateStudent implements RequestHandler<UpdateStudentRequest, UpdateStudentResult> {
    private final Logger log = LogManager.getLogger();
    private final StudentDAO studentDAO;


    @Inject
    public UpdateStudent(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public UpdateStudentResult handleRequest(UpdateStudentRequest updateStudentRequest, Context context) {
        log.info("Received UpdateStudentRequest {}", updateStudentRequest);

        Student student = studentDAO.getStudent(updateStudentRequest.getSchoolId(), updateStudentRequest.getId());

        if (student == null) {
            throw new StudentNotFoundException();
        }

        student.setId(updateStudentRequest.getId());
        student.setAddress(updateStudentRequest.getAddress());
        student.setEmail(updateStudentRequest.getEmail());
        student.setGender(updateStudentRequest.getGender());
        student.setFirstName(updateStudentRequest.getFirstName());
        student.setMiddleName(updateStudentRequest.getMiddleName());
        student.setLastName(updateStudentRequest.getLastName());
        student.setSchoolId(updateStudentRequest.getSchoolId());

        this.studentDAO.saveStudent(student);

        StudentModel studentModel = new ModelConverter().toStudentModel(student);

        return UpdateStudentResult.builder()
                .withStudentModel(studentModel)
                .build();
    }
}
