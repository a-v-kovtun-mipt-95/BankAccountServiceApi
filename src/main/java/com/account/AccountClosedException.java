package com.account;

public class AccountClosedException extends RuntimeException {

    public AccountClosedException(int accountNumber) {
        super(String.format("Account %d is closed", accountNumber));
    }
    
}
