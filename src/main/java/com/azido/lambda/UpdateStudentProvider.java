package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.models.Request.UpdateAssignmentRequest;
import com.azido.models.Request.UpdateStudentRequest;
import com.azido.models.Result.UpdateAssignmentResult;
import com.azido.models.Result.UpdateStudentResult;

public class UpdateStudentProvider implements RequestHandler<UpdateStudentRequest, UpdateStudentResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    @Override
    public UpdateStudentResult handleRequest(UpdateStudentRequest updateStudentRequest, Context context) {
        return dagger.provideUpdateStudent().handleRequest(updateStudentRequest,context);
    }
}
