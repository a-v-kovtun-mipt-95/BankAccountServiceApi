package com.account;

public class AccountNotFoundException  extends RuntimeException {

    public AccountNotFoundException(int accountNumber) {
        super(String.format("Account %d not found", accountNumber));
    }
    
}
