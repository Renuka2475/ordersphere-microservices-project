package com.order.placeNewOrder.dto;

public class OrderBookResponse {

    private Long orderId;
    private String foodItem;
    private int qty;
    private int price;
    private String location;
    private String email;


    public OrderBookResponse() {
    }

    public OrderBookResponse(Long orderId, String foodItem, int qty, int price, String location, String email) {
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

    @Override
    public String toString() {
        return "OrderBookResponse{" + "orderId=" + orderId + ", foodItem='" + foodItem + '\'' + ", qty=" + qty + ", price=" + price + ", location='" + location + '\'' + ", email='" + email + '\'' + '}';
    }
}
