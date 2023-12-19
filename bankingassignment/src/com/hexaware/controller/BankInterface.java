package com.hexaware.controller;

import com.hexaware.entity.Account;
import com.hexaware.entity.Customer;

public interface BankInterface {
    public void getAccountBalance(long accountNumber);

    public void deposit(long accountNumber, double amount);

    public void withdraw(long accountNumber, double amount);

    public void transfer(long fromAccountNumber, long toAccountNumber, double amount);

    public void getAccountDetails(long accountNumber);

	public void createAccount(Customer customer, Account account);
}
