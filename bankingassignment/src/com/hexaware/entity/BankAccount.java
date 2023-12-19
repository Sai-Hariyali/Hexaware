package com.hexaware.entity;

public abstract class BankAccount {
	private int accountnumber;
	private String customername;
	private double balance;
	
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int accountnumber, String customername, double balance) {
		super();
		this.accountnumber = accountnumber;
		this.customername = customername;
		this.balance = balance;
	}
	
}
