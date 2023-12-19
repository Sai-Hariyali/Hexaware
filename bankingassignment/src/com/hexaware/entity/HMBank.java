package com.hexaware.entity;

import java.util.HashMap;
import java.util.Map;

import com.hexaware.exception.InsufficientFundException;
import com.hexaware.exception.InvalidAccountException;
import com.hexaware.exception.OverDraftLimitExcededException;

public class HMBank {
	private Map<Long, Account> accounts = new HashMap<Long, Account>();
	
	public void withdraw(long accountNumber, double amount) throws InsufficientFundException, 
	OverDraftLimitExcededException, InvalidAccountException {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new InvalidAccountException();
        }
        if (amount > account.getAccountbalance()) {
            throw new InsufficientFundException();
        }
        if (account instanceof CurrentAccount && amount > 500) {
            throw new OverDraftLimitExcededException();
        }
        account.setAccountbalance(account.getAccountbalance() - amount);
    }
	
	public void transfer(long fromAccountNumber, long toAccountNumber, double amount) throws InsufficientFundException,
	InvalidAccountException {
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);
        if (fromAccount == null || toAccount == null) {
            throw new InvalidAccountException();
        }
        if (amount > fromAccount.getAccountbalance()) {
            throw new InsufficientFundException();
        }
        fromAccount.setAccountbalance(fromAccount.getAccountbalance() - amount);
        toAccount.setAccountbalance(toAccount.getAccountbalance() + amount);
    }
	
	public double getAccountBalance(long accountNumber) {
        Account account = accounts.get(accountNumber);
        return (account != null) ? account.getAccountbalance() : -1;
    }
	
	public void addAccount(Account account) {
        accounts.put((long) account.getAccountNumber(), account);
    }
	
	public void listAccounts() {
	    for (Map.Entry<Long, Account> entry : accounts.entrySet()) {
	        Account account = entry.getValue();
	        System.out.println(account);
	    }
	}

}
