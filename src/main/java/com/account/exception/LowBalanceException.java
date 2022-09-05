package com.account.exception;

public class LowBalanceException  extends RuntimeException {

    public LowBalanceException(int accountNumber) {
        super(String.format("Account %d balance is less than the debit operation ammount", accountNumber));
    }
    
}
