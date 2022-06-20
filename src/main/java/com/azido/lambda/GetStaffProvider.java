package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.models.Request.GetAssignmentRequest;
import com.azido.models.Request.GetStaffRequest;
import com.azido.models.Result.GetAssignmentResult;
import com.azido.models.Result.GetStaffResult;

public class GetStaffProvider implements RequestHandler<GetStaffRequest, GetStaffResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    @Override
    public GetStaffResult handleRequest(GetStaffRequest getStaffRequest, Context context) {
        return dagger.provideGetStaff().handleRequest(getStaffRequest,context);
    }
}
