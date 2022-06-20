package com.azido.endpoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.Converter.ModelConverter;
import com.azido.dao.AssignmentDAO;
import com.azido.dynamodb.models.Assignment;
import com.azido.exceptions.AssignmentNotFoundException;
import com.azido.models.AssignmentModel;
import com.azido.models.Request.GetAssignmentRequest;
import com.azido.models.Result.GetAssignmentResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetAssignment implements RequestHandler<GetAssignmentRequest, GetAssignmentResult> {
    private final Logger log = LogManager.getLogger();
    private final AssignmentDAO assignmentDao;


    @Inject
    public GetAssignment(AssignmentDAO assignmentDAO) {
        this.assignmentDao = assignmentDAO;
    }

    @Override
    public GetAssignmentResult handleRequest(final GetAssignmentRequest getAssignmentRequest, Context context) {
        log.info("Received AddAssignmentResult {}", getAssignmentRequest);

        Assignment assignment = assignmentDao.getAssignment(getAssignmentRequest.getId(), getAssignmentRequest.getStudentId());

        if (assignment == null) {
            throw new AssignmentNotFoundException();
        }

        AssignmentModel assignmentModel = new ModelConverter().toAssignmentModel(assignment);

        return GetAssignmentResult.builder()
                .withAssignmentModel(assignmentModel)
                .build();
    }
}
