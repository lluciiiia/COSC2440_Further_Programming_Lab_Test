package com.example.seokyungkim_s3939114.Request;

import java.sql.Date;

public class UpdateOrderRequest {

    private int id;
    private int deliverymanId;
    private double totalPrice;

    public UpdateOrderRequest(int id, int deliverymanId, double totalPrice) {
        this.id = id;
        this.deliverymanId = deliverymanId;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public int getDeliverymanId() {
        return deliverymanId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

}
