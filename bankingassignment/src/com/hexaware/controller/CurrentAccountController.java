package com.hexaware.controller;

public class CurrentAccountController extends AccountController{
	@Override
	public void withdraw(double amount)
	{
		double overdraftlimit = -1000;
		double amt=0;
		System.out.println("Enter balance: ");
		double balance = sc.nextDouble();
		System.out.println("Enter withdraw amount:");
		double withdraw=sc.nextDouble();
		double currentbalance=balance+overdraftlimit;
		if(withdraw>currentbalance){
			 amt = balance - withdraw;
			 System.out.println(withdraw+" withdrawn successfully.Remaining credit to bank is "+amt);
		}
		else{
			System.out.println("insufficient balance");		
		}
	}
	
	@Override
	public void calculateInterest()
	{
		System.out.println("No interest calculation for current account");
	}
}
