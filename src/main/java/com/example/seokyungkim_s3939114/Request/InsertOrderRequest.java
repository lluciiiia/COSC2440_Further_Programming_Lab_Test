package com.example.seokyungkim_s3939114.Request;

import java.sql.Date;

public class InsertOrderRequest {

    private int customerId;
    private int deliverymanId;
    private double totalPrice;

    public InsertOrderRequest(int customerId, int deliverymanId, double totalPrice) {
        this.customerId = customerId;
        this.deliverymanId = deliverymanId;
        this.totalPrice = totalPrice;
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
}
