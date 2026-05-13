package com.order.notification_service.bean;

public class NotificationRequest {

    private String email;


    public NotificationRequest() {
    }

    public NotificationRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
