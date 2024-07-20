package com.example.atmservice.service.serviceImpl;


import com.example.atmservice.entity.Account;
import com.example.atmservice.events.BalanceChangeEvent;
import com.example.atmservice.repository.AccountRepository;
import com.example.atmservice.service.AccountService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private KafkaTemplate<String, BalanceChangeEvent> kafkaTemplate;


    @Override
    @Transactional
    public synchronized void deposit(Long accountId, Double amount) {
    	  
	  Account account = accountRepository.findById(accountId).orElse(null);

	    if (account == null) {
	        account = new Account();
	        account.setAccountId(accountId);
	        account.setBalance(amount);
	    } else {
	        account.setBalance(account.getBalance() + amount);
	    }

    	accountRepository.save(account);
        

       
        kafkaTemplate.send("balances", new BalanceChangeEvent(account.getAccountId(), "DEPOSIT", account.getBalance()));
    }


    @Override
    @Transactional
    public synchronized void withdraw(Long accountId, Double amount) {
    	
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() >= amount && account.getBalance() - amount > 0 ) {
            account.setBalance(account.getBalance() - amount);
            accountRepository.save(account);
            kafkaTemplate.send("balances", new BalanceChangeEvent(accountId,"WITHDRAW", account.getBalance()));
        } else {
            kafkaTemplate.send("balances", new BalanceChangeEvent(accountId,"WITHDRAW", account.getBalance()));
            throw new RuntimeException("Insufficient balance");
        }
    }

    @Override
    public Account getAccount(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

}
