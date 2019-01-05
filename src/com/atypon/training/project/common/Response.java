package com.atypon.training.project.common;

public final class Response {
    private String body;
    private ResponseStatus status;

    public Response(String body, ResponseStatus status) {
        this.body = body;
        this.status = status;
    }

    public Response(){
        this.body = "Error reading request";
        this.status = ResponseStatus.ServerError;
    }

    public String getBody() {
        return body;
    }

    public ResponseStatus getStatus() {
        return status;
    }
}
