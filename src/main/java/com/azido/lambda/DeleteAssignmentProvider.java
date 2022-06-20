package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.models.Request.DeleteAssignmentRequest;
import com.azido.models.Result.DeleteAssignmentResult;

public class DeleteAssignmentProvider implements RequestHandler<DeleteAssignmentRequest, DeleteAssignmentResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    @Override
    public DeleteAssignmentResult handleRequest(DeleteAssignmentRequest deleteAssignmentRequest, Context context) {
        return dagger.provideDeleteAssignment().handleRequest(deleteAssignmentRequest,context);
    }
}
