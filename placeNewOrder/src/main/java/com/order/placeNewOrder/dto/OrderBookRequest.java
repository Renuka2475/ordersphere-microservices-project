package com.order.placeNewOrder.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class OrderBookRequest {


    private Long orderId;
    @NotBlank(message = "Food Item is required")
    private String foodItem;

    @Min(value = 1, message = "Minimum Qty should be 1")
    private int qty;

    @Min(value = 1, message = "Price should be in Positive")
    private int price;

    @NotBlank(message = "Location is required")
    private String location;

    @Email(message = "Invalid Email Format")
    @NotBlank(message = "Email is required")
    private String email;

    public OrderBookRequest() {
    }

    public OrderBookRequest(Long orderId, String foodItem, int qty, int price, String location, String email) {
        this.orderId = orderId;
        this.foodItem = foodItem;
        this.qty = qty;
        this.price = price;
        this.location = location;
        this.email = email;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
