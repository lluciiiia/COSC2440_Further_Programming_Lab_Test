package com.example.seokyungkim_s3939114.Facade;

import com.example.seokyungkim_s3939114.Model.Customer;
import com.example.seokyungkim_s3939114.Request.InsertCustomerRequest;
import com.example.seokyungkim_s3939114.Request.UpdateCustomerRequest;

import java.util.List;

public interface CustomerFacade {
    void addCustomer(InsertCustomerRequest request);

    void updateCustomer(UpdateCustomerRequest request);

    void deleteCustomer(int id);

    Customer getCustomerById(int id);

    List<Customer> searchCustomersByName(String name);
}
