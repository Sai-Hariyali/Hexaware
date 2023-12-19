package com.hexaware.controller;

public interface AccountInterface {
	
	public void deposit(double amount);
	  public void withdraw(double amount);
	  public void calculateInterest();
	  
	  public void deposit(int amount);
	  public void deposit(float amount);
	  
	  public void withdraw(int amount);
	  public void withdraw(float amount);
}
