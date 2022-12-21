package com.waller.walletapi.repository;

import com.waller.walletapi.model.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankTransactionRepository extends JpaRepository<BankTransaction, Integer> {
}
