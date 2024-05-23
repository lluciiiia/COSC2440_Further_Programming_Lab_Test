package com.example.seokyungkim_s3939114.FacadeImpl;


import com.example.seokyungkim_s3939114.Facade.OrderFacade;
import com.example.seokyungkim_s3939114.Model.Order;
import com.example.seokyungkim_s3939114.Repository.CustomerRepository;
import com.example.seokyungkim_s3939114.Repository.OrderRepository;
import com.example.seokyungkim_s3939114.Request.InsertOrderRequest;
import com.example.seokyungkim_s3939114.Request.UpdateOrderRequest;

public class OrderFacadeImpl implements OrderFacade {

    OrderRepository orderRepository;

    public OrderFacadeImpl() {
        this.orderRepository = new OrderRepository();
    }


    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteOrderById(id);
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public void updateOrder(UpdateOrderRequest request) {
        orderRepository.updateOrder(request);
    }

    @Override
    public void addCustomer(InsertOrderRequest request) {
        orderRepository.addOrder(request);
    }
}
