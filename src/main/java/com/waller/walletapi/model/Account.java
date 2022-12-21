package com.waller.walletapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNumber;
    private float accountBalance;
    @ManyToOne
    private Customer accountHolder;
    @ManyToOne
    @JsonIgnore
    private Wallet walletHolder;
    @OneToMany(mappedBy = "transactionFromAccount")
    private List<BankTransaction> bankTransaction;
    private static final long serialVersionUID = 1L;
}
