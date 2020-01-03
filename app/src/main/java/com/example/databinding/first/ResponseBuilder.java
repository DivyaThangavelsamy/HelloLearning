package com.example.databinding.first;

import javax.inject.Inject;

public class ResponseBuilder {

    private SuccessResponse success;
    private FailureResponse failure;
    String message;

    @Inject
    public ResponseBuilder(SuccessResponse successResponse, FailureResponse failureResponse) {
        success = successResponse;
        failure = failureResponse;
    }

    public String getValidation(String username, String password) {
        ResponseBuilderComponent responseBuilderComponent = DaggerResponseBuilderComponent.create();
        if ("admin".equals(username) && "admin".equals(password)) {
            message = responseBuilderComponent.getSuccesResponseObj().getSuccessMessage();


        } else {
            message = responseBuilderComponent.getFailureResponseObj().getFailureMessage();
        }
        return message;
    }


}
