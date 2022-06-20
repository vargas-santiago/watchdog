package com.azido.endpoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.Converter.ModelConverter;
import com.azido.dao.ClassDAO;
import com.azido.dynamodb.models.ClassObject;
import com.azido.exceptions.ClassNotFoundException;
import com.azido.models.ClassModel;
import com.azido.models.Request.AddClassRequest;
import com.azido.models.Request.UpdateClassRequest;
import com.azido.models.Result.AddClassResult;
import com.azido.models.Result.UpdateClassResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateClass implements RequestHandler<UpdateClassRequest, UpdateClassResult> {
    private final Logger log = LogManager.getLogger();
    private final ClassDAO classDAO;


    @Inject
    public UpdateClass(ClassDAO classDAO) {
        this.classDAO = classDAO;
    }

    @Override
    public UpdateClassResult handleRequest(UpdateClassRequest updateClassRequest, Context context) {
        log.info("Received UpdateClassRequest {}", updateClassRequest);

        ClassObject classObject = classDAO.getClass(updateClassRequest.getStudentId(), updateClassRequest.getId());

        if (classObject == null) {
            throw new ClassNotFoundException();
        }

        classObject.setId(updateClassRequest.getId());
        classObject.setStudentId(updateClassRequest.getStudentId());
        classObject.setName(updateClassRequest.getName());
        classObject.setSubject( updateClassRequest.getSubject());
        classObject.setAssignments(updateClassRequest.getAssignments());

        this.classDAO.saveClass(classObject);

        ClassModel classModel = new ModelConverter().toClassModel(classObject);

        return UpdateClassResult.builder()
                .withClassModel(classModel)
                .build();
    }
}
