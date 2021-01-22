package com.vetclinic.exception;

public class ExceptionResponse {

    private int status;

    private String message;

    private long timeStamp;

    public ExceptionResponse(){}

    public ExceptionResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}
