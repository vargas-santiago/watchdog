package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.models.Request.AddClassRequest;
import com.azido.models.Request.DeleteClassRequest;
import com.azido.models.Result.AddClassResult;
import com.azido.models.Result.DeleteClassResult;

public class DeleteClassProvider implements RequestHandler<DeleteClassRequest, DeleteClassResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    @Override
    public DeleteClassResult handleRequest(DeleteClassRequest deleteClassRequest, Context context) {
        return dagger.provideDeleteClass().handleRequest(deleteClassRequest,context);
    }
}
