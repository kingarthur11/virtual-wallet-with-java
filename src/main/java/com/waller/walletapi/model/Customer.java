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
public class Customer {
    @Id
    @GeneratedValue

    private int userId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @OneToOne(mappedBy = "customerWallet")
    private Wallet wallet;
    @OneToMany(mappedBy = "accountHolder")
    private List<Account> customerAccounts;
    private static final long serialVersionUID = 1L;
}
