package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.endpoint.UpdateAssignment;
import com.azido.models.Request.AddAssignmentRequest;
import com.azido.models.Request.UpdateAssignmentRequest;
import com.azido.models.Result.AddAssignmentResult;
import com.azido.models.Result.UpdateAssignmentResult;

public class UpdateAssignmentProvider implements RequestHandler<UpdateAssignmentRequest, UpdateAssignmentResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    @Override
    public UpdateAssignmentResult handleRequest(UpdateAssignmentRequest updateAssignmentRequest, Context context) {
        return dagger.provideUpdateAssignment().handleRequest(updateAssignmentRequest,context);
    }
}
