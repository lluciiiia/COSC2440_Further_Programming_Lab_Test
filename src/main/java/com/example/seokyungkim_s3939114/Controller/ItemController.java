package com.example.seokyungkim_s3939114.Controller;

import com.example.seokyungkim_s3939114.Facade.ItemFacade;
import com.example.seokyungkim_s3939114.FacadeImpl.ItemFacadeImpl;
import com.example.seokyungkim_s3939114.Model.Customer;
import com.example.seokyungkim_s3939114.Model.Item;
import com.example.seokyungkim_s3939114.Request.InsertItemRequest;
import com.example.seokyungkim_s3939114.Request.UpdateItemRequest;

import java.util.List;

public class ItemController {

    private ItemFacade itemFacade;

    public ItemController() {
        this.itemFacade = new ItemFacadeImpl();
    }

    public void addItem(InsertItemRequest request) {
        itemFacade.addItem(request);
    }

    public void updateItem(UpdateItemRequest request) {
        itemFacade.updateItem(request);
    }

    public void deleteItem(int id) {
        itemFacade.deleteItem(id);
    }

    public Item getItemById(int id) {
        return itemFacade.getItemById(id);
    }

    public List<Item> searchItemsByName(String name) {
        return itemFacade.searchItemsByName(name);
    }
}
