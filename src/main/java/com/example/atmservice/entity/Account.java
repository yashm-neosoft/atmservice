package com.example.atmservice.entity;


import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name="account")
public class Account implements Serializable {
    //private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="accountid")
    private Long accountId;

    @Column(name="balance")
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}

