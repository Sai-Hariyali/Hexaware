package com.hexaware.entity;


public class SavingsAccount extends Account {
	private double interestrate;
	
	public double getInterestrate() {
		return interestrate;
	}

	public void setInterestrate(double interestrate) {
		this.interestrate = interestrate;
	}
	
	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(int accountnumber, String accounttype, 
			double accountbalance, Customer customer,
			double interestrate) {
		super(accountnumber, accounttype, 500, customer);
		this.interestrate = interestrate;
	}
	
}
