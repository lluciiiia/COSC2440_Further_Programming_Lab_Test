package com.example.seokyungkim_s3939114.FacadeImpl;

import com.example.seokyungkim_s3939114.Facade.CustomerFacade;
import com.example.seokyungkim_s3939114.Model.Customer;
import com.example.seokyungkim_s3939114.Repository.CustomerRepository;
import com.example.seokyungkim_s3939114.Request.InsertCustomerRequest;
import com.example.seokyungkim_s3939114.Request.UpdateCustomerRequest;

import java.util.List;

public class CustomerFacadeImpl implements CustomerFacade {
    CustomerRepository customerRepository;

    public CustomerFacadeImpl() {
        this.customerRepository = new CustomerRepository();
    }
    @Override
    public void addCustomer(InsertCustomerRequest request) {
        customerRepository.addCustomer(request);
    }

    @Override
    public void updateCustomer(UpdateCustomerRequest request) {
        customerRepository.updateCustomer(request);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomerById(id);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> searchCustomersByName(String name) {
        return customerRepository.searchCustomersByName(name);
    }
}
