package com.hexaware.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.hexaware.entity.Account;
import com.hexaware.entity.Bank;
import com.hexaware.entity.SavingsAccount;

public class AccountController implements AccountInterface {
	private Map<Long, Account> accounts = new HashMap<Long, Account>();
	Account acc = new Account();
	SavingsAccount savingsAccount = new SavingsAccount();
	 Scanner sc = new Scanner(System.in);
	@Override
	public void calculateInterest() {
		
		System.out.println("Enter balance:");
		double balance=sc.nextInt();
		double interest = balance*0.045;
		System.out.println("Interest: "+interest);
		balance=balance+interest;
		System.out.println("balance with interest is:" +balance);
	}
	
	@Override
	public void deposit(double amount) {
		
		System.out.println("Enter balance: ");
		double balance = sc.nextDouble();
		System.out.println("Enter deposit amount:");
		double deposit=sc.nextDouble();
		double total= balance+deposit;
		System.out.println(deposit + " deposited successfully. Total balance is "+total);
	}
	
	@Override
	public void withdraw(double amount)
	{

		System.out.println("Enter balance: ");
		double balance = sc.nextDouble();
		System.out.println("Enter withdraw amount: ");
		double withdraw=sc.nextDouble();
		if(balance>=withdraw)
		{
			double amt = balance - withdraw;
			System.out.println(withdraw+" withdrawn successfully.Remaining balance is "+amt);
		}
		else{
			System.out.println("insufficient balance");
		}
		
	}

	@Override
	public void deposit(int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit(float amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(float amount) {
		// TODO Auto-generated method stub
		
	}
	public double getAccountBalance(long accountNumber) {
        
        Account account = accounts.get(accountNumber);
        if (account != null) {
        	return account.getAccountbalance();
        } else {
           return -1; 
        }
    }

}
