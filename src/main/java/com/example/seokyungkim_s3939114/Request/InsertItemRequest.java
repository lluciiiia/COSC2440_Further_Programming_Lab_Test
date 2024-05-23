package com.example.seokyungkim_s3939114.Request;

public class InsertItemRequest {

    private String name;
    private double price;

    public InsertItemRequest(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
