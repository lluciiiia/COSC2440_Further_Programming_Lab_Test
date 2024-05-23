package com.example.seokyungkim_s3939114.Model;

import java.sql.Date;

public class Customer {

    private int id;
    private String name;

    private String address;
    private String phoneNumber;
    private Date createdAt;

    public Customer(int id, String name, String address, String phoneNumber, Date createdAt) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
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

    public Date getCreatedAt() {
        return createdAt;
    }
}
