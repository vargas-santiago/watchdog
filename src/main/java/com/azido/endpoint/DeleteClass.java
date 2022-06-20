package com.azido.endpoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.Converter.ModelConverter;
import com.azido.dao.ClassDAO;
import com.azido.dynamodb.models.ClassObject;
import com.azido.exceptions.ClassNotFoundException;
import com.azido.models.ClassModel;
import com.azido.models.Request.DeleteClassRequest;
import com.azido.models.Result.DeleteClassResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class DeleteClass implements RequestHandler<DeleteClassRequest, DeleteClassResult> {
    private final Logger log = LogManager.getLogger();
    private final ClassDAO classDAO;


    @Inject
    public DeleteClass(ClassDAO classDAO) {
        this.classDAO = classDAO;
    }

    @Override
    public DeleteClassResult handleRequest(DeleteClassRequest deleteClassRequest, Context context) {
        log.info("DeleteClassRequest GetClassRequest {}", deleteClassRequest);

        ClassObject classObject = classDAO.getClass(deleteClassRequest.getStudentId(), deleteClassRequest.getId());

        if (classObject == null) {
            throw new ClassNotFoundException();
        }

        this.classDAO.deleteClass(classObject);

        ClassModel classModel = new ModelConverter().toClassModel(classObject);

        return DeleteClassResult.builder()
                .withClassModel(classModel)
                .build();
    }
}
