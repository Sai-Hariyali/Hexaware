package com.hexaware.entity;

public class ZeroBalanceAccount extends Account{

	public ZeroBalanceAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ZeroBalanceAccount(long accountNumber, String accounttype, double accountbalance, Customer customer) {
		super(accountNumber, accounttype, 0, customer);
		// TODO Auto-generated constructor stub
	}

	
}
