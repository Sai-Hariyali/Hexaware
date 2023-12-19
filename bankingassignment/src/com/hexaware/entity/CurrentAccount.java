package com.hexaware.entity;

public class CurrentAccount extends Account {
	private static final double overdraftlimit=-1000;

	public double getOverdraftlimit() {
		return overdraftlimit;
	}
//	public void setOverdraftlimit(double overdraftlimit) {
//		this.overdraftlimit = overdraftlimit;
//	}
	
	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(int accountnumber, String accounttype,
			double accountbalance, Customer customer) {
		super(accountnumber, accounttype, 0, customer);
		// TODO Auto-generated constructor stub
	}

	
}
