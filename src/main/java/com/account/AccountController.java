package com.account;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.account.data.Account;
import com.account.data.AccountOperation;
import com.account.data.Status;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    @GetMapping("/check")
    public Status checkStatus(@RequestParam(value = "account", defaultValue = "0") int account) {
        return accountService.check(account);
    }

    @GetMapping("/balance")
    public Account getBalance(@RequestParam(value = "account", defaultValue = "0") int account) {
        return accountService.balance(account);
    }

    @PutMapping("/operation")
    public void performOperation(@RequestBody AccountOperation operation) {
        accountService.performOperation(operation);
    }
}
