package com.atypon.training.project.common;

import java.util.Map;

public final class Request {
    private Operation operation;
    private Map<String,String> params;

    public Request(Operation operation, Map<String, String> params) {
        this.operation = operation;
        this.params = params;
    }

    public Operation getOperation() {
        return operation;
    }

    public Map<String, String> getParams() {
        return params;
    }
}
