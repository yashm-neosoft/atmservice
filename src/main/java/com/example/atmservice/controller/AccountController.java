package com.example.atmservice.controller;

import com.example.atmservice.entity.Account;
import com.example.atmservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/{accountId}/deposit/{amount}")
    public String deposit(@PathVariable Long accountId, @PathVariable double amount) {
        accountService.deposit(accountId,amount);
        return String.valueOf(new ResponseEntity<>("Amount Deposited", HttpStatus.OK));
    }

    @PostMapping("/{accountId}/withdraw/{amount}")
    public String withdraw(@PathVariable Long accountId, @PathVariable double amount) {
        accountService.withdraw(accountId, amount);
        return String.valueOf(new ResponseEntity<>("Amount Withdrawed", HttpStatus.OK));
    }

    @GetMapping("/{accountId}")
    public Account getAccount(@PathVariable Long accountId) {
        return accountService.getAccount(accountId);
    }
}

