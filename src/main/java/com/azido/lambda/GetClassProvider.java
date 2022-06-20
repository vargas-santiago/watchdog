package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.models.Request.GetAssignmentRequest;
import com.azido.models.Request.GetClassRequest;
import com.azido.models.Result.GetAssignmentResult;
import com.azido.models.Result.GetClassResult;

public class GetClassProvider implements RequestHandler<GetClassRequest, GetClassResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    @Override
    public GetClassResult handleRequest(GetClassRequest getClassRequest, Context context) {
        return dagger.provideGetClass().handleRequest(getClassRequest,context);
    }
}
