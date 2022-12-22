package com.waller.walletapi.service;

import com.waller.walletapi.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public List<Customer> fetchAllCustomers();
    public Iterable<Customer> fetchCustomerByEmail(String email);
    public Customer fetchCustomer(Integer customerId);
}
