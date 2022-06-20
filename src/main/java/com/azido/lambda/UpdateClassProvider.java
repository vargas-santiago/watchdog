package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.endpoint.UpdateClass;
import com.azido.models.Request.UpdateClassRequest;
import com.azido.models.Request.UpdateStaffRequest;
import com.azido.models.Result.UpdateClassResult;
import com.azido.models.Result.UpdateStaffResult;

public class UpdateClassProvider implements RequestHandler<UpdateClassRequest, UpdateClassResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    @Override
    public UpdateClassResult handleRequest(UpdateClassRequest updateClassRequest, Context context) {
        return dagger.provideUpdateClass().handleRequest(updateClassRequest,context);
    }
}
