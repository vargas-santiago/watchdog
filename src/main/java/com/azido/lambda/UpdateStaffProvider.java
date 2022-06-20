package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.models.Request.UpdateSchoolRequest;
import com.azido.models.Request.UpdateStaffRequest;
import com.azido.models.Result.UpdateSchoolResult;
import com.azido.models.Result.UpdateStaffResult;

public class UpdateStaffProvider implements RequestHandler<UpdateStaffRequest, UpdateStaffResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    @Override
    public UpdateStaffResult handleRequest(UpdateStaffRequest updateStaffRequest, Context context) {
        return dagger.provideUpdateStaff().handleRequest(updateStaffRequest,context);
    }
}
