package com.hexaware.controller;

import java.util.HashMap;
import java.util.Map;

import com.hexaware.entity.Account;
import com.hexaware.entity.Customer;

public class BankServiceProviderImpl extends CustomerServiceProviderImpl implements IBankServiceProvider {
	 private String branchName;
	 private String branchAddress;
	 
	 @Override
	public String toString() {
		return "BankServiceProviderImpl [accounts=" + accounts + ", savingsaccountcontroller="
				+ savingsaccountcontroller + "]";
	}
	public  BankServiceProviderImpl() {
		 super();
	 }
	 public BankServiceProviderImpl(String branchName, String branchAddress) {
	        this.branchName = branchName;
	        this.branchAddress = branchAddress;
	    }
	 
	private Map<Long, Account> accounts = new HashMap<Long, Account>();
	SavingsAccountController savingsaccountcontroller;
  
	@Override
    public void create_account(Customer customer, long accountNumber, String accountType, double balance) {
        Account account= new Account(accountNumber, accountType, balance, customer);
        accounts.put(accountNumber, account);
             System.out.println("Account created successfully.");
    }

    @Override
    public void listAccounts() {
        System.out.println("List of Accounts:");
        for (Account account : accounts.values()) {
            System.out.println(account);
        }
    }

    @Override
    public void calculateInterest() {
    	for (Account account : accounts.values()) {
    	savingsaccountcontroller = new SavingsAccountController();
    	savingsaccountcontroller.calculateInterest();
    	}
    }
	@Override
	public void getAccountDetails(long accountnumber) {
		// TODO Auto-generated method stub
		 if (accounts.containsKey(accountnumber)) {
	            Account account = accounts.get(accountnumber);
	            System.out.println("Account Details:");
	            System.out.println("Account Number: " + account.getAccountNumber());
	            System.out.println("Account Type: " + account.getAccounttype());
	            System.out.println("Account Balance: " + account.getAccountbalance());
	            System.out.println("Customer ID: " + account.getCustomer().getCustomerid());
	        } else {
	            System.out.println("Account not found for account number: " + accountnumber);
	        }
		
	}

}
