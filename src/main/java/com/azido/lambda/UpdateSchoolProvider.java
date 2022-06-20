package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.models.Request.UpdateSchoolRequest;
import com.azido.models.Request.UpdateStudentRequest;
import com.azido.models.Result.UpdateSchoolResult;
import com.azido.models.Result.UpdateStudentResult;

public class UpdateSchoolProvider implements RequestHandler<UpdateSchoolRequest, UpdateSchoolResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    @Override
    public UpdateSchoolResult handleRequest(UpdateSchoolRequest updateStudentRequest, Context context) {
        return dagger.provideUpdateSchool().handleRequest(updateStudentRequest,context);
    }
}
