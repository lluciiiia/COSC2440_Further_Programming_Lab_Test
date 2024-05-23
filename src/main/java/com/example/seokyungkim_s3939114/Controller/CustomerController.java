package com.example.seokyungkim_s3939114.Controller;

import com.example.seokyungkim_s3939114.Facade.CustomerFacade;
import com.example.seokyungkim_s3939114.FacadeImpl.CustomerFacadeImpl;
import com.example.seokyungkim_s3939114.Model.Customer;
import com.example.seokyungkim_s3939114.Request.InsertCustomerRequest;
import com.example.seokyungkim_s3939114.Request.UpdateCustomerRequest;

import java.util.List;

public class CustomerController {

    private CustomerFacade customerFacade;

    public CustomerController() {
        this.customerFacade = new CustomerFacadeImpl();
    }

    public void addCustomer(InsertCustomerRequest request) {
        customerFacade.addCustomer(request);
    }

    public void updateCustomer(UpdateCustomerRequest request) {
        customerFacade.updateCustomer(request);
    }

    public void deleteCustomer(int id) {
        customerFacade.deleteCustomer(id);
    }

    public Customer getCustomerById(int id) {
        return customerFacade.getCustomerById(id);
    }

    public List<Customer> searchCustomersByName(String name) {
        return customerFacade.searchCustomersByName(name);
    }
}
