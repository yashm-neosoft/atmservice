package com.example.atmservice.service;

import com.example.atmservice.entity.Account;

import java.util.Optional;

public interface AccountService {
//    void deposit(String accountId, double amount);
//    void withdraw(String accountId, double amount);
//    Account getAccount(String accountId);
	
	void deposit(Long accountId, Double amount);
	void withdraw(Long accountId, Double amount);
    Account getAccount(Long accountId);
	
	
}
