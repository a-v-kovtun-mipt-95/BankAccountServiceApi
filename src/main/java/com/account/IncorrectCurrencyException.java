package com.account;

public class IncorrectCurrencyException extends RuntimeException {

    public IncorrectCurrencyException(int accountNumber) {
        super(String.format("Account %d currency is differ than the operation currency", accountNumber));
    }
    
}
