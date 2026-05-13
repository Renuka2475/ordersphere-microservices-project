package com.order.placeNewOrder.dto;

public class PaymentRequest {

    private Long orderId;
    private String userid;
    private String email;
    private int amount;

    public PaymentRequest() {
    }

    public PaymentRequest(Long orderId, int amount, String email, String userid) {
        this.orderId = orderId;
        this.amount = amount;
        this.email = email;
        this.userid = userid;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
