package com.pragma.challenge.clean.infrastructure.exceptionhandler;

public enum ExceptionResponse {
    PERSON_ALREADY_EXISTS("Person already exists"),
    PERSON_NOT_FOUND("Person not found");


    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
