package com.example.seokyungkim_s3939114.Request;

public class InsertCustomerRequest {
    private String name;
    private String address;
    private String phoneNumber;

    public InsertCustomerRequest(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
