package com.example.seokyungkim_s3939114.Request;

public class UpdateDeliverymanRequest {

    private int id;
    private String name;
    private String phoneNumber;

    public UpdateDeliverymanRequest(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
