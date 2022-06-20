package com.azido.endpoint;

import com.amazonaws.Request;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.Converter.ModelConverter;
import com.azido.dao.AssignmentDAO;
import com.azido.dao.StudentDAO;
import com.azido.dynamodb.models.Assignment;
import com.azido.exceptions.AssignmentNotFoundException;
import com.azido.models.AssignmentModel;
import com.azido.models.Request.AddAssignmentRequest;
import com.azido.models.Request.UpdateAssignmentRequest;
import com.azido.models.Result.AddAssignmentResult;
import com.azido.models.Result.UpdateAssignmentResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateAssignment implements RequestHandler<UpdateAssignmentRequest, UpdateAssignmentResult> {
    private final Logger log = LogManager.getLogger();
    private final AssignmentDAO  assignmentDao;


    @Inject
    public UpdateAssignment(AssignmentDAO assignmentDAO) {
        this.assignmentDao = assignmentDAO;
    }

    @Override
    public UpdateAssignmentResult handleRequest(UpdateAssignmentRequest updateAssignmentRequest, Context context) {
        log.info("Received UpdateAssignmentRequest {}", updateAssignmentRequest);

        Assignment assignment = assignmentDao.getAssignment(updateAssignmentRequest.getId(), updateAssignmentRequest.getStudentId());

        if (assignment == null) {
            throw new AssignmentNotFoundException();
        }

        assignment.setId(updateAssignmentRequest.getId());
        assignment.setStudentId(updateAssignmentRequest.getStudentId());
        assignment.setTitle(updateAssignmentRequest.getTitle());
        assignment.setStudentScore(updateAssignmentRequest.getStudentScore());
        assignment.setMaxScore(updateAssignmentRequest.getMaxScore());
        assignment.setNotes(updateAssignmentRequest.getNotes());

        this.assignmentDao.saveAssignment(assignment);

        AssignmentModel assignmentModel = new ModelConverter().toAssignmentModel(assignment);

        return UpdateAssignmentResult.builder()
                .withAssignmentModel(assignmentModel)
                .build();
    }
}
