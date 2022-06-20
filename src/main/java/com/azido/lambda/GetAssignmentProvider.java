package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.models.Request.DeleteAssignmentRequest;
import com.azido.models.Request.GetAssignmentRequest;
import com.azido.models.Result.DeleteAssignmentResult;
import com.azido.models.Result.GetAssignmentResult;

public class GetAssignmentProvider implements RequestHandler<GetAssignmentRequest, GetAssignmentResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    @Override
    public GetAssignmentResult handleRequest(GetAssignmentRequest getAssignmentRequest, Context context) {
        return dagger.provideGetAssignment().handleRequest(getAssignmentRequest,context);
    }
}
