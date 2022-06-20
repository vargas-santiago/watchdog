package com.azido.endpoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.Converter.ModelConverter;
import com.azido.dao.StaffDao;
import com.azido.dao.StudentDAO;
import com.azido.dynamodb.models.Staff;
import com.azido.dynamodb.models.Student;
import com.azido.exceptions.StaffNotFoundException;
import com.azido.exceptions.StudentNotFoundException;
import com.azido.models.Request.GetStaffRequest;
import com.azido.models.Request.GetStudentRequest;
import com.azido.models.Result.GetStaffResult;
import com.azido.models.Result.GetStudentResult;
import com.azido.models.StaffModel;
import com.azido.models.StudentModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetStudent implements RequestHandler<GetStudentRequest, GetStudentResult> {
    private final Logger log = LogManager.getLogger();
    private final StudentDAO studentDAO;


    @Inject
    public GetStudent(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public GetStudentResult handleRequest(GetStudentRequest getStudentRequest, Context context) {
        log.info("Received GetStudentRequest {}", getStudentRequest);

        Student student = studentDAO.getStudent(getStudentRequest.getSchoolId(), getStudentRequest.getId());

        if (student == null) {
            throw new StudentNotFoundException();
        }

        StudentModel studentModel = new ModelConverter().toStudentModel(student);

        return GetStudentResult.builder()
                .withStudentModel(studentModel)
                .build();
    }
}
