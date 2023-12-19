package com.hexaware.entity;

public class Account {
	private int accountnumber;
	 private String accounttype;
	 private double accountbalance;
	 private static int lastAccNo = 1000;
	 private Customer customer;
	 
	 public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public double getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}
	
	@Override
	public String toString() {
		return "Account [accountnumber=" + accountnumber + ", accounttype=" + accounttype + ", accountbalance="
				+ accountbalance + "]";
	}
	
	public Account(long accountNumber, String accounttype, double accountbalance,Customer customer) {
		super();
		this.accountnumber = generateAccountnumber();
		this.accounttype = accounttype;
		this.accountbalance = accountbalance;
		this.customer = customer;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getAccountNumber() {
        return accountnumber;
    }

    private static int generateAccountnumber() {
        lastAccNo++;
        return lastAccNo;
    }
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		
	}
	public void withdraw(double withdrawAmount) {
		// TODO Auto-generated method stub
		
	}
	
	
}