package com.waller.walletapi.exception;

import com.waller.walletapi.model.Customer;

public class CustomerAlreadyHasWalletException extends Exception{
    public CustomerAlreadyHasWalletException(Customer customer) {
        super("Customer " +customer.getFirstName() + " " +customer.getLastName()+ " already owns a wallet: " +customer.getWallet().getWalletId());
    }
}
