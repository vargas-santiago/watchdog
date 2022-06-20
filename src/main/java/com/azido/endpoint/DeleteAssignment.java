package com.azido.endpoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.Converter.ModelConverter;
import com.azido.dao.AssignmentDAO;
import com.azido.dynamodb.models.Assignment;
import com.azido.models.AssignmentModel;
import com.azido.models.Request.DeleteAssignmentRequest;
import com.azido.models.Result.DeleteAssignmentResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class DeleteAssignment implements RequestHandler<DeleteAssignmentRequest, DeleteAssignmentResult> {

    private final Logger log = LogManager.getLogger();
    private final AssignmentDAO assignmentDao;


    @Inject
    public DeleteAssignment(AssignmentDAO assignmentDAO) {
        this.assignmentDao = assignmentDAO;
    }

    @Override
    public DeleteAssignmentResult handleRequest(DeleteAssignmentRequest deleteAssignmentRequest, Context context) {
        log.info("Received DeleteAssignmentRequest {}", deleteAssignmentRequest);

        Assignment assignment = new Assignment();
        assignment.setId(deleteAssignmentRequest.getId());
        assignment.setStudentId(deleteAssignmentRequest.getStudentId());

        this.assignmentDao.deleteAssignment(assignment);

        AssignmentModel assignmentModel = new ModelConverter().toAssignmentModel(assignment);

        return DeleteAssignmentResult.builder()
                .withAssignmentModel(assignmentModel)
                .build();
    }
}