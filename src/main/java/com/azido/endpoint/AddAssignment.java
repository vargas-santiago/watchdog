package com.azido.endpoint;

import com.amazonaws.Request;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.Converter.ModelConverter;
import com.azido.dao.AssignmentDAO;
import com.azido.dao.StudentDAO;
import com.azido.dynamodb.models.Assignment;
import com.azido.models.AssignmentModel;
import com.azido.models.Request.AddAssignmentRequest;
import com.azido.models.Result.AddAssignmentResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class AddAssignment implements RequestHandler<AddAssignmentRequest, AddAssignmentResult> {
    private final Logger log = LogManager.getLogger();
    private final AssignmentDAO  assignmentDao;


    @Inject
    public AddAssignment(AssignmentDAO assignmentDAO) {
        this.assignmentDao = assignmentDAO;
    }

    @Override
    public AddAssignmentResult handleRequest(final AddAssignmentRequest addAssignmentRequest, Context context) {
        log.info("Received AddAssignmentResult {}", addAssignmentRequest);

        Assignment assignment = new Assignment();
        assignment.setId(addAssignmentRequest.getId());
        assignment.setStudentId(addAssignmentRequest.getStudentId());
        assignment.setTitle(addAssignmentRequest.getTitle());
        assignment.setStudentScore(addAssignmentRequest.getStudentScore());
        assignment.setMaxScore(addAssignmentRequest.getMaxScore());
        assignment.setNotes(addAssignmentRequest.getNotes());

        this.assignmentDao.saveAssignment(assignment);

        AssignmentModel assignmentModel = new ModelConverter().toAssignmentModel(assignment);

        return AddAssignmentResult.builder()
                .withAssignmentModel(assignmentModel)
                .build();
    }
}
