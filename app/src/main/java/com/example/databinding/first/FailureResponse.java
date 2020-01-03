package com.example.databinding.first;

import javax.inject.Inject;


public class FailureResponse {
    @Inject
    public FailureResponse() {
    }

    public String getFailureMessage() {
        return "Failure";
    }
}

