package com.example.databinding.first;

import javax.inject.Inject;

public class SuccessResponse {
    @Inject
    public SuccessResponse() {
    }

    public String getSuccessMessage() {
        return "Success";
    }
}
