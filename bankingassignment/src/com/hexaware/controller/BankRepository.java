package com.hexaware.controller;

import java.util.Date;

import com.hexaware.entity.Customer;

public interface BankRepository {
	public void createAccount(Customer customer,long accountnumber,String accountype,double balance);

	public void listAccounts();

	public void calculateInterest();

	public void getAccountBalance(long accountNumber);

	public void deposit(long accountNumber, double amount);

	public void withdraw(long accountNumber, double amount);

	public void transfer(long fromAccountNumber, long toAccountNumber, double amount);

	public void getAccountDetails(long accountNumber);

	public void getTransactions(long accountNumber, Date fromDate, Date toDate);
}
