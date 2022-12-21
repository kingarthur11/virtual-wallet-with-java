package com.waller.walletapi.service;

import com.waller.walletapi.exception.CustomerAlreadyHasWalletException;
import com.waller.walletapi.exception.CustomerDoesNotExistException;
import com.waller.walletapi.model.Customer;
import com.waller.walletapi.model.Wallet;
import com.waller.walletapi.repository.AccountRepository;
import com.waller.walletapi.repository.CustomerRepository;
import com.waller.walletapi.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("walletService")
public class WalletServiceImp implements WalletService{
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;

//    @Override
//    public Wallet createWallet(Integer customerId) {
//        return null;
//    }

    @Override
    public Wallet createWallet(Integer customerId) throws CustomerDoesNotExistException, CustomerAlreadyHasWalletException {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if(customer == null)  {
            throw new CustomerDoesNotExistException(customerId);
        }
        if (customer.getWallet() != null) {
            throw new CustomerAlreadyHasWalletException(customer);
        }
        Wallet wallet = new Wallet();
        wallet.setCustomerWallet(customer);
        if (customer.getCustomerAccounts() != null && !customer.getCustomerAccounts().isEmpty()) {
            wallet.setAccountsInWallet(new ArrayList<>(customer.getCustomerAccounts()));
        }
        return walletRepository.save(wallet);
    }
}
