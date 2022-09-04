package com.account;

import java.math.BigDecimal;

public class AccountOperation {

    private int accountNumber;

    private int currecy;
    
    private BigDecimal amount;

    private OperationSign sign;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCurrecy() {
        return currecy;
    }

    public void setCurrecy(int currecy) {
        this.currecy = currecy;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OperationSign getSign() {
        return sign;
    }

    public void setSign(OperationSign sign) {
        this.sign = sign;
    }

    
}
