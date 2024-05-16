package com.example.coffeeshop.service;

import com.example.coffeeshop.model.Customer;

import java.util.List;

public interface CustomerService {
    public String createCustomer(Customer customer);
    public String updateCustomer(Customer customer);
    public String deleteCustomer(Long customerID);
    public Customer getCustomer(Long customerID);
    public List<Customer> getAllCustomers();

}
