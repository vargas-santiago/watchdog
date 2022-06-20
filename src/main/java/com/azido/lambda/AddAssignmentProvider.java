package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.models.Request.AddAssignmentRequest;
import com.azido.models.Result.AddAssignmentResult;

public class AddAssignmentProvider implements RequestHandler<AddAssignmentRequest, AddAssignmentResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();
    @Override
    public AddAssignmentResult handleRequest(AddAssignmentRequest addAssignmentRequest, Context context) {
        return dagger.provideAddAssignment().handleRequest(addAssignmentRequest,context);
    }
}
