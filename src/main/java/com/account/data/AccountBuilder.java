package com.account.data;

import java.math.BigDecimal;

public class AccountBuilder {

    private int accountNumber;

    private int currecy;
    
    private BigDecimal balance;

    private Status status;

    public AccountBuilder withAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public AccountBuilder withCurrecy(int currecy) {
        this.currecy = currecy;
        return this;
    }

    public AccountBuilder withBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public AccountBuilder withStatus(Status status) {
        this.status = status;
        return this;
    }

    public Account build() {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setCurrecy(currecy);
        account.setBalance(balance);
        account.setStatus(status);
        return account;
    }
}
