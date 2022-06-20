package com.azido.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.azido.dependency.DaggerServiceComponent;
import com.azido.dependency.ServiceComponent;
import com.azido.models.Request.GetClassRequest;
import com.azido.models.Request.GetDistrictRequest;
import com.azido.models.Result.GetClassResult;
import com.azido.models.Result.GetDistrictResult;

public class GetDistrictProvider implements RequestHandler<GetDistrictRequest, GetDistrictResult> {

    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    @Override
    public GetDistrictResult handleRequest(GetDistrictRequest getDistrictRequest, Context context) {
        return dagger.provideGetDistrict().handleRequest(getDistrictRequest,context);
    }
}
