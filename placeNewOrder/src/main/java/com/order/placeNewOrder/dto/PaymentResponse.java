package com.order.placeNewOrder.dto;

public class PaymentResponse {
    private String status;
    private String userId;
    private String transactionId;
    private double amount;

    public PaymentResponse() {
    }

    public PaymentResponse(String status, String userId, String transactionId, double amount) {
        this.status = status;
        this.userId = userId;
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
