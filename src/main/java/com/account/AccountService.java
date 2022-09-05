package com.account;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.data.Account;
import com.account.data.AccountOperation;
import com.account.data.OperationSign;
import com.account.data.Status;
import com.account.exception.AccountClosedException;
import com.account.exception.AccountNotFoundException;
import com.account.exception.IncorrectAmountException;
import com.account.exception.IncorrectCurrencyException;
import com.account.exception.LowBalanceException;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    public Status check(int accountNumber) {
        List<Account> accounts = accountRepository.findByAccountNumber(accountNumber);
        if(accounts.size()>0) {
            return accounts.get(0).getStatus();
        } else {
            throw new AccountNotFoundException(accountNumber);
        }
    }

    public Account balance(int accountNumber) {
        List<Account> accounts = accountRepository.findByAccountNumber(accountNumber);
        if(accounts.size()>0) {
            return accounts.get(0);
        } else {
            throw new AccountNotFoundException(accountNumber);
        }
    }

    public void performOperation(AccountOperation operation) {
        int accountNumber = operation.getAccountNumber();
        List<Account> accounts = accountRepository.findByAccountNumber(accountNumber);
        if(accounts.size()>0) {
            Account account = accounts.get(0);
            if(account.getStatus().equals(Status.CLOSED)) throw new AccountClosedException(accountNumber);
            if(account.getCurrecy() != operation.getCurrecy()) throw new IncorrectCurrencyException(accountNumber);
            if(operation.getAmount().compareTo(BigDecimal.ZERO) <= 0) throw new IncorrectAmountException(accountNumber);
            if(operation.getSign().equals(OperationSign.DEBIT)) {
                if(operation.getAmount().compareTo(account.getBalance())>0) {
                    throw new LowBalanceException(accountNumber);
                }
                account.setBalance(account.getBalance().subtract(operation.getAmount()));
            } else {
                account.setBalance(account.getBalance().add(operation.getAmount()));
            }
            accountRepository.save(account);
        } else {
            throw new AccountNotFoundException(accountNumber);
        }
    }
}
