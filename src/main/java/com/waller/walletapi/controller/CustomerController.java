package com.waller.walletapi.controller;

import com.waller.walletapi.model.Customer;
import com.waller.walletapi.repository.CustomerRepository;
import com.waller.walletapi.service.CustomerService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(CustomerController.class);
    @PostMapping("/api/customer")
    public Customer createCustomer(@RequestBody Customer customer) {

        return customerService.createCustomer(customer);
    }

    @GetMapping("/api/customer/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId) {
        LOGGER.info("the user id is -> " +customerId);
        return customerService.fetchCustomer(customerId);
    }

    @GetMapping("/api/customer")
    public List<Customer> getAllCustomers(@RequestParam(name = "email", required = false) String email) {
        if(email != null) {
            return (List<Customer>) customerService.fetchCustomerByEmail(email);
        }
        return (List<Customer>) customerService.fetchAllCustomers();
    }
}
