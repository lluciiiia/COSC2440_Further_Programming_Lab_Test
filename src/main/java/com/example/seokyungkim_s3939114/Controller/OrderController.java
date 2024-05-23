package com.example.seokyungkim_s3939114.Controller;

import com.example.seokyungkim_s3939114.Facade.OrderFacade;
import com.example.seokyungkim_s3939114.FacadeImpl.OrderFacadeImpl;
import com.example.seokyungkim_s3939114.Model.Order;
import com.example.seokyungkim_s3939114.Request.InsertOrderRequest;
import com.example.seokyungkim_s3939114.Request.UpdateOrderRequest;

public class OrderController {

    private OrderFacade orderFacade;

    public OrderController() {
        this.orderFacade = new OrderFacadeImpl();
    }

    public void addOrder(InsertOrderRequest request) {
        orderFacade.addCustomer(request);
    }

    public void updateOrder(UpdateOrderRequest request) {
        orderFacade.updateOrder(request);
    }

    public void deleteOrder(int id) {
        orderFacade.deleteOrder(id);
    }

    public Order getOrderById(int id) {
        return orderFacade.getOrderById(id);
    }

}