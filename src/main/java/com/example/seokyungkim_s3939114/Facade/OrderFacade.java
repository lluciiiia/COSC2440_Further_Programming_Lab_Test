package com.example.seokyungkim_s3939114.Facade;

import com.example.seokyungkim_s3939114.Model.Order;
import com.example.seokyungkim_s3939114.Request.InsertOrderRequest;
import com.example.seokyungkim_s3939114.Request.UpdateOrderRequest;

public interface OrderFacade {
    void deleteOrder(int id);

    Order getOrderById(int id);

    void updateOrder(UpdateOrderRequest request);

    void addCustomer(InsertOrderRequest request);
}
