package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.models.Request.AddAssignmentRequest;
import com.azido.models.Request.AddClassRequest;
import com.azido.models.Result.AddAssignmentResult;
import com.azido.models.Result.AddClassResult;

public class AddClassProvider implements RequestHandler<AddClassRequest, AddClassResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    @Override
    public AddClassResult handleRequest(AddClassRequest addClassRequest, Context context) {
        return dagger.provideAddClass().handleRequest(addClassRequest,context);
    }
}
