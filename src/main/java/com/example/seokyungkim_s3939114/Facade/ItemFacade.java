package com.example.seokyungkim_s3939114.Facade;

import com.example.seokyungkim_s3939114.Model.Item;
import com.example.seokyungkim_s3939114.Request.InsertItemRequest;
import com.example.seokyungkim_s3939114.Request.UpdateItemRequest;

import java.util.List;

public interface ItemFacade {
    void addItem(InsertItemRequest request);

    void updateItem(UpdateItemRequest request);

    void deleteItem(int id);

    Item getItemById(int id);

    List<Item> searchItemsByName(String name);
}
