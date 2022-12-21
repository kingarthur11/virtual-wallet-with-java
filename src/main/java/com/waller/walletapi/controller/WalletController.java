package com.waller.walletapi.controller;

import com.waller.walletapi.exception.CustomerAlreadyHasWalletException;
import com.waller.walletapi.exception.CustomerDoesNotExistException;
import com.waller.walletapi.exception.WalletIdDoesNotExistException;
import com.waller.walletapi.model.Account;
import com.waller.walletapi.model.ServiceResponse;
import com.waller.walletapi.model.Wallet;
import com.waller.walletapi.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {
    @Autowired
    WalletService walletService;

    @PostMapping("api/wallet/{customerId}")
    public ResponseEntity<ServiceResponse> createWallet(@PathVariable("customerId") int customerId) throws CustomerAlreadyHasWalletException {

        ServiceResponse response = new ServiceResponse();

        try {
            Wallet newWallet = walletService.createWallet(customerId);
            response.setStatus("200");
            response.setDescription("Wallet created successfully");
            response.setData(newWallet);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CustomerDoesNotExistException e) {
            response.setStatus(String.valueOf(HttpStatus.NOT_FOUND));
            response.setDescription(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (CustomerAlreadyHasWalletException e) {
            response.setStatus(String.valueOf(HttpStatus.EXPECTATION_FAILED));
            response.setDescription(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
        }
    }

}
