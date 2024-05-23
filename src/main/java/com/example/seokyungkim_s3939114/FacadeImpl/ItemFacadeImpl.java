package com.example.seokyungkim_s3939114.FacadeImpl;

import com.example.seokyungkim_s3939114.Facade.ItemFacade;
import com.example.seokyungkim_s3939114.Model.Item;
import com.example.seokyungkim_s3939114.Repository.ItemRepository;
import com.example.seokyungkim_s3939114.Request.InsertItemRequest;
import com.example.seokyungkim_s3939114.Request.UpdateItemRequest;

import java.util.List;

public class ItemFacadeImpl implements ItemFacade {

    private ItemRepository itemRepository;

    public ItemFacadeImpl() {
        this.itemRepository = new ItemRepository();
    }

    @Override
    public void addItem(InsertItemRequest request) {
        itemRepository.addItem(request);
    }

    @Override
    public void updateItem(UpdateItemRequest request) {
        itemRepository.updateItem(request);
    }

    @Override
    public void deleteItem(int id) {
        itemRepository.deleteItemById(id);
    }

    @Override
    public Item getItemById(int id) {
        return itemRepository.getItemById(id);
    }

    @Override
    public List<Item> searchItemsByName(String name) {
        return itemRepository.searchItemsByName(name);
    }
}
