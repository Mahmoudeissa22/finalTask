package com.Task.engnour.ErrorHandling;

public class EmployeeErrorResponse {

    private int status;
    private String message;
    private double timeStamp;


    public EmployeeErrorResponse() {
    }

    public EmployeeErrorResponse(int status, String message, double timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(double timeStamp) {
        this.timeStamp = timeStamp;
    }



}
