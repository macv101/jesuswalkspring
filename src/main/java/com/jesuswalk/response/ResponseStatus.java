package com.jesuswalk.response;

public enum ResponseStatus {
    SUCCESS("Success"),
    EMPTY("Returned empty result"),
    BAD_REQUEST("Invalid parameters"),
    INTERNAL_ERROR("Internal error");

    private String message;

    ResponseStatus(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
