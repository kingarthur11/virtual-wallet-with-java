package com.waller.walletapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
@Entity
public class BankTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private String type;
    private Date timestamp;
    private float amount;
    private float postBalance;
    private float description;
    @ManyToOne
    @JsonIgnore
    private Account transactionFromAccount;
}
