package com.loanapp.loanapp.service;

import com.loanapp.loanapp.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(String id);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Customer customer);
    void deleteCustomer(String id);
    Customer createCustomer(Customer customer);
}
