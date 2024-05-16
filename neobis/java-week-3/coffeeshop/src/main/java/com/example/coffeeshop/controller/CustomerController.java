package com.example.coffeeshop.controller;

import com.example.coffeeshop.model.Customer;
import com.example.coffeeshop.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("{customerID}")
    public Customer getCustomerDetails(@PathVariable("customerID") Long customerID){
        return customerService.getCustomer(customerID);
    }

    @GetMapping()
    public List<Customer> getAllCustomerDetails(){
        return customerService.getAllCustomers();
    }

    @PostMapping
    public String createCustomerDetails(@RequestBody Customer customer){
        customerService.createCustomer(customer);
        return "Customer Created Successfully.";
    }

    @PutMapping
    public String updateCustomerDetails(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
        return "Customer Updated Successfully.";
    }

    @DeleteMapping("{customerID}")
    public String deleteCustomerDetails(@PathVariable("{customerID}") Long customerID){
        customerService.deleteCustomer(customerID);
        return "Customer Deleted Successfully.";
    }

}
