package com.hexaware.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hexaware.entity.Account;
import com.hexaware.entity.Customer;
import com.hexaware.entity.Transaction;

public class CustomerServiceProviderImpl implements ICustomerServiceProvider{
	private Map<Long, Account> accounts = new HashMap<Long, Account>();
	private Map<Long, List<Transaction>> transactionsByAccount = new HashMap<>();
	Account account; 
	@Override
    public void get_account_balance(long accountNumber) {
        double balance = getAccountBalance(accountNumber);
        if (balance != -1) {
            System.out.println("Account Balance for Account Number " + accountNumber + ": " + balance);
        } else {
            System.out.println("Account not found for Account Number: " + accountNumber);
        }
    }

    private double getAccountBalance(long accountNumber) {
		// TODO Auto-generated method stub
    	account=new Account();
    	 if (account != null) {
             return account.getAccountbalance();
         } else {
             return -1; 
         }
	}

	@Override
    public void deposit(long accountNumber, double amount) {
        depositAmount(accountNumber, amount);
        System.out.println("Deposit successful.");
    }

    @Override
    public void withdraw(long accountNumber, double withdrawAmount) {
        withdrawAmount(accountNumber, withdrawAmount);
        System.out.println("Withdrawal successful.");
    }

    @Override
    public void transfer(long fromAccountNumber, long toAccountNumber, double amount) {
        transferAmount(fromAccountNumber, toAccountNumber, amount);
        System.out.println("Transfer successful.");
    }

    @Override
    public void getAccountDetails(long accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            Customer customer = account.getCustomer();
            System.out.println("Account Details:");
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Type: " + account.getAccounttype());
            System.out.println("Account Balance: " + account.getAccountbalance());
            System.out.println("Customer ID: " + customer.getCustomerid());
            System.out.println("Customer Name: " + customer.getFirstname() + " " + customer.getLastname());
            System.out.println("Customer Email: " + customer.getEmailaddress());
            System.out.println("Customer Phone Number: " + customer.getPhonenumber());
            System.out.println("Customer Address: " + customer.getAddress());
        } else {
            System.out.println("Account not found.");
        }
    }

    
    private void depositAmount(long accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
        }
    }

    private void withdrawAmount(long accountNumber, double withdrawAmount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(withdrawAmount);
        }
    }

    private void transferAmount(long fromAccountNumber, long toAccountNumber, double amount) {
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);

        if (fromAccount != null && toAccount != null) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        }
    }

	@Override
	public void getTransactions(long accountnumber, Date fromdate, Date todate) {
		// TODO Auto-generated method stub
		if (transactionsByAccount.containsKey(accountnumber)) {
            List<Transaction> transactions = transactionsByAccount.get(accountnumber);
            List<Transaction> filteredTransactions = new ArrayList<>();
            for (Transaction transaction : transactions) {
                if (!transaction.getDateandtime().before(fromdate) &&
                    !transaction.getDateandtime().after(todate)) {
                    filteredTransactions.add(transaction);
                }
            }
         if (!filteredTransactions.isEmpty()) {
         System.out.println("Transactions for Account " + accountnumber + " between " + fromdate + " and " + todate + ":");
                for (Transaction transaction : filteredTransactions) {
                    System.out.println(transaction);
                }
            } else {
                System.out.println("No transactions found for the specified date range.");
            }

        } else {
            System.out.println("No transactions found for Account " + accountnumber);
        }
	}

}
