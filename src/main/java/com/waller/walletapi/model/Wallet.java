package com.waller.walletapi.model;

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
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer walletId;
    @OneToMany(mappedBy = "walletHolder")
    private List<Account> accountsInWallet;
    @OneToOne
    private Customer customerWallet;
    private static final long serialVersionUID = 1L;
}
