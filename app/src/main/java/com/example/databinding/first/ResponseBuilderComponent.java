package com.example.databinding.first;

import dagger.Component;

@Component

public interface ResponseBuilderComponent {

    ResponseBuilder getResponseBuilder();

    SuccessResponse getSuccesResponseObj();

    FailureResponse getFailureResponseObj();

    void buiderComponentInject(LoginActivity loginActivity);


}
