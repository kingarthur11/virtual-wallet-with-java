package com.waller.walletapi.exception;

public class CustomerDoesNotExistException extends Exception{
    public CustomerDoesNotExistException(Integer customerId) {
        super("Customer with customer ID: " +customerId + " does not exist");
    }
}
