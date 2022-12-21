package com.waller.walletapi.service;

import com.waller.walletapi.exception.CustomerAlreadyHasWalletException;
import com.waller.walletapi.exception.CustomerDoesNotExistException;
import com.waller.walletapi.model.Wallet;

public interface WalletService {
    public Wallet createWallet(Integer customerId) throws CustomerDoesNotExistException, CustomerAlreadyHasWalletException;
//    public Wallet createWallet(Integer customerId);
}
