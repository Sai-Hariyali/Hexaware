package com.hexaware.controller;

public class SavingsAccountController extends AccountController{
	@Override
	public void calculateInterest()
	{
		System.out.println("Enter balance:");
		double balance=sc.nextDouble();
		System.out.println("Enter interest rate:");
		double interestrate=sc.nextDouble();
		double interest = balance*interestrate;
		System.out.println("Interest: "+interest);
		balance=balance+interest;
		System.out.println("balance with interest is:" +balance);
	}
}
