package com.example.seokyungkim_s3939114.Request;

public class InsertDeliverymanRequest {

    private String name;
    private String phoneNumber;

    public InsertDeliverymanRequest(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
