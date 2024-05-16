package com.example.coffeeshop.service.impl;

import com.example.coffeeshop.model.Customer;
import com.example.coffeeshop.repository.CustomerRepository;
import com.example.coffeeshop.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public String createCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Success";
    }

    @Override
    public String updateCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Success";
    }

    @Override
    public String deleteCustomer(Long customerID) {
        customerRepository.deleteById(customerID);
        return "Success";
    }

    @Override
    public Customer getCustomer(Long customerID) {
        return customerRepository.findById(customerID).get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
