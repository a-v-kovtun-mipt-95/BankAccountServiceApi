package com.account;

public class IncorrectAmountException extends RuntimeException {

    public IncorrectAmountException(int accountNumber) {
        super(String.format("Operation amount must be positive (account %d)", accountNumber));
    }
    
}
