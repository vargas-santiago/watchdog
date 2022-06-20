package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.models.Request.GetDistrictRequest;
import com.azido.models.Request.GetSchoolRequest;
import com.azido.models.Result.GetDistrictResult;
import com.azido.models.Result.GetSchoolResult;

public class GetSchoolProvider implements RequestHandler<GetSchoolRequest, GetSchoolResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    @Override
    public GetSchoolResult handleRequest(GetSchoolRequest getSchoolRequest, Context context) {
        return dagger.provideGetSchool().handleRequest(getSchoolRequest,context);
    }
}
