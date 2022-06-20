package com.azido.endpoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.Converter.ModelConverter;
import com.azido.dao.ClassDAO;
import com.azido.dynamodb.models.ClassObject;
import com.azido.exceptions.ClassNotFoundException;
import com.azido.models.ClassModel;
import com.azido.models.Request.GetClassRequest;
import com.azido.models.Result.GetClassResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetClass implements RequestHandler<GetClassRequest, GetClassResult> {
    private final Logger log = LogManager.getLogger();
    private final ClassDAO classDAO;


    @Inject
    public GetClass(ClassDAO classDAO) {
        this.classDAO = classDAO;
    }

    @Override
    public GetClassResult handleRequest(GetClassRequest getClassRequest, Context context) {
        log.info("Received GetClassRequest {}", getClassRequest);

        ClassObject classObject = classDAO.getClass(getClassRequest.getStudentId(), getClassRequest.getId());

        if (classObject == null) {
            throw new ClassNotFoundException();
        }

        ClassModel classModel = new ModelConverter().toClassModel(classObject);

        return GetClassResult.builder()
                .withClassModel(classModel)
                .build();
    }
}
