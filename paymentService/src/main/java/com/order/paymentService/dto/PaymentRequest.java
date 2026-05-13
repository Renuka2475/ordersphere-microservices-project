package com.order.paymentService.dto;

public class PaymentRequest {

    private int orderId;
    private String userid;
    private String email;
    private double amount;

    public PaymentRequest() {
    }

    public PaymentRequest(int orderId, double amount, String email, String userid) {
        this.orderId = orderId;
        this.amount = amount;
        this.email = email;
        this.userid = userid;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
