package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.models.Request.GetClassRequest;
import com.azido.models.Request.GetStudentRequest;
import com.azido.models.Result.GetClassResult;
import com.azido.models.Result.GetStudentResult;

public class GetStudentProvider implements RequestHandler<GetStudentRequest, GetStudentResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    @Override
    public GetStudentResult handleRequest(GetStudentRequest getStudentRequest, Context context) {
        return dagger.provideGetStudent().handleRequest(getStudentRequest,context);
    }
}
