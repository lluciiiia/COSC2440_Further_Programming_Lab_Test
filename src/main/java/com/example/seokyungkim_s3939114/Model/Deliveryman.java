package com.example.seokyungkim_s3939114.Model;

import java.sql.Date;

public class Deliveryman {

    private int id;
    private String name;
    private String phoneNumber;
    private Date createdAt;

    public Deliveryman(int id, String name, String phoneNumber, Date createdAt) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
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

    public Date getCreatedAt() {
        return createdAt;
    }
}
