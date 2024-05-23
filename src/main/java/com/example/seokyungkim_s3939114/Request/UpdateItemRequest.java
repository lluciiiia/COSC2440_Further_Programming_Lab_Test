package com.example.seokyungkim_s3939114.Request;

public class UpdateItemRequest {
    private int id;
    private String name;
    private double price;

    public UpdateItemRequest(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
