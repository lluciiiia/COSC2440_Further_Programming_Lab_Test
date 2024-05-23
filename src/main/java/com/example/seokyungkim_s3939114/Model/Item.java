package com.example.seokyungkim_s3939114.Model;

import java.sql.Date;

public class Item {
    private int id;
    private String name;
    private double price;
    private Date createdAt;

    public Item(int id, String name, double price, Date createdAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdAt = createdAt;
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

    public Date getCreatedAt() {
        return createdAt;
    }
}
