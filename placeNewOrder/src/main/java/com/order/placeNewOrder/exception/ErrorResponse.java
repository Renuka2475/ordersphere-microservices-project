package com.order.placeNewOrder.exception;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime time;
    private String error;
    private int status;
    private String message;
    private URI path;

    public ErrorResponse() {
    }

    public ErrorResponse(LocalDateTime time, String error, int status, String message, URI path) {
        this.time = time;
        this.error = error;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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

    public URI getPath() {
        return path;
    }

    public void setPath(URI path) {
        this.path = path;
    }
}
