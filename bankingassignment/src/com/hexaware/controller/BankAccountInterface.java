package com.hexaware.controller;

public interface BankAccountInterface {
	public void deposit(double amount);

    public void withdraw(double amount);

    public void calculateInterest();
}
