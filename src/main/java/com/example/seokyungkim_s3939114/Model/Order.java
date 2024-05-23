package com.example.seokyungkim_s3939114.Model;

import java.sql.Date;

public class Order {
    private int id;
    private int customerId;
    private int deliverymanId;
    private double totalPrice;
    private Date createdAt;

    public Order(int id, int customerId, int deliverymanId, double totalPrice, Date createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.deliverymanId = deliverymanId;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getDeliverymanId() {
        return deliverymanId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
