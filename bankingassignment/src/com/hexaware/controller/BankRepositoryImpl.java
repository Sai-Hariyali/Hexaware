package com.hexaware.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.hexaware.dao.AccountDao;
import com.hexaware.dao.CustomerDao;
import com.hexaware.entity.Account;
import com.hexaware.entity.Customer;
import com.hexaware.exception.InsufficientFundException;

public class BankRepositoryImpl implements BankRepository {
	Scanner scanner = new Scanner(System.in);
	List  accountlist = new ArrayList();
	private Map<Long, Account> accounts = new HashMap<Long,Account>();

	Account account;
	AccountDao accountdao ;
	Customer customer;
	SavingsAccountController savingsaccountcontroller;
	
	@Override
	public void createAccount(Customer customer, long accountnumber, String accountype, double balance) {
		// TODO Auto-generated method stub
		account = new Account();
		accountdao = new AccountDao();
        System.out.print("Enter customer id: ");
        int customerId = scanner.nextInt();
        customer = new Customer();
        customer.setCustomerid(customerId);
        account.setCustomer(customer);
        
        System.out.print("Enter account type: ");
        String accountType = scanner.next();
        account.setAccounttype(accountType);
        System.out.print("Enter account balance: ");
        double accountBalance = scanner.nextDouble();
       account.setAccountbalance(accountBalance);
       accountdao.saveAccount(account);
       System.out.println("Account added successfully");
	}

	@Override
	public void listAccounts() {
		// TODO Auto-generated method stub
		System.out.println("List of Accounts:");
        for (Account account : accounts.values()) {
            System.out.println(account);
        }
	}

	@Override
	public void calculateInterest() {
		// TODO Auto-generated method stub
		savingsaccountcontroller = new SavingsAccountController();
		savingsaccountcontroller.calculateInterest();
	}

	@Override
	public void getAccountBalance(long accountNumber) {
		// TODO Auto-generated method stub
		if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber).getAccountbalance();
            System.out.println("Balance for Account " + accountNumber + ": " + balance);
        } else {
            System.out.println("Account not found for Account Number: " + accountNumber);
        }
	}

	@Override
	public void deposit(long accountNumber, double amount) {
		// TODO Auto-generated method stub
		 if (accounts.containsKey(accountNumber)) {
	            Account account = accounts.get(accountNumber);
	            account.deposit(amount);
	            System.out.println("Deposit successful. New balance: " + account.getAccountbalance());
	        } else {
	            System.out.println("Account not found for Account Number: " + accountNumber);
	        }
	}

	@Override
	public void withdraw(long accountNumber, double amount) {
		// TODO Auto-generated method stub
		if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            account.withdraw(amount);
			System.out.println("Withdrawal successful. New balance: " + account.getAccountbalance());
        } else {
            System.out.println("Account not found for Account Number: " + accountNumber);
        }
	}

	@Override
	public void transfer(long fromAccountNumber, long toAccountNumber, double amount) {
		// TODO Auto-generated method stub
        if (accounts.containsKey(fromAccountNumber) && accounts.containsKey(toAccountNumber)) {
            Account fromAccount = accounts.get(fromAccountNumber);
            Account toAccount = accounts.get(toAccountNumber);
            fromAccount.withdraw(amount);
			toAccount.deposit(amount);
			System.out.println("Transfer successful.");
        } else {
            System.out.println("One or both of the accounts not found.");
        }

	}

	@Override
	public void getAccountDetails(long accountNumber) {
		// TODO Auto-generated method stub
		if (accounts.containsKey(accountNumber)) {
            System.out.println("Account Details for Account " + accountNumber + ":");
            System.out.println(accounts.get(accountNumber));
        } else {
            System.out.println("Account not found for Account Number: " + accountNumber);
        }
	}

	@Override
	public void getTransactions(long accountNumber, Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
	    System.out.println("Transactions for Account " + accountNumber + " between " + fromDate + " and " + toDate + ":");
	}
	 
}
