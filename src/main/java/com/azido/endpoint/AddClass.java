package com.azido.endpoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.Converter.ModelConverter;
import com.azido.dao.AssignmentDAO;
import com.azido.dao.ClassDAO;
import com.azido.dynamodb.models.Assignment;
import com.azido.dynamodb.models.ClassObject;
import com.azido.models.AssignmentModel;
import com.azido.models.ClassModel;
import com.azido.models.Request.AddAssignmentRequest;
import com.azido.models.Request.AddClassRequest;
import com.azido.models.Result.AddAssignmentResult;
import com.azido.models.Result.AddClassResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class AddClass implements RequestHandler<AddClassRequest, AddClassResult> {
    private final Logger log = LogManager.getLogger();
    private final ClassDAO classDAO;


    @Inject
    public AddClass(ClassDAO classDAO) {
        this.classDAO = classDAO;
    }

    @Override
    public AddClassResult handleRequest(AddClassRequest addClassRequest, Context context) {
        log.info("Received AddClassRequest {}", addClassRequest);

        ClassObject classObject = new ClassObject();
        classObject.setId(addClassRequest.getId());
        classObject.setStudentId(addClassRequest.getStudentId());
        classObject.setName(addClassRequest.getName());
        classObject.setSubject( addClassRequest.getSubject());
        classObject.setAssignments(addClassRequest.getAssignments());

        this.classDAO.saveClass(classObject);

        ClassModel classModel = new ModelConverter().toClassModel(classObject);

        return AddClassResult.builder()
                .withClassModel(classModel)
                .build();
    }
}
