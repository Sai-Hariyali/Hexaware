package com.hexaware.entity;

import java.util.Scanner;
import com.hexaware.controller.BankAccountInterface;

public class SavingsAccountBA implements BankAccountInterface {
	private double interestrate;
	Scanner sc=new Scanner(System.in);
	public double getInterestrate() {
		return interestrate;
	}
	public void setInterestrate(double interestrate) {
		this.interestrate = interestrate;
	}

	public SavingsAccountBA(int accountnumber, String customername, double balance, double interestrate) {
		this.interestrate = interestrate;
	}
	public SavingsAccountBA() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
    public void calculateInterest() {
		System.out.println("Enter balance:");
        double balance=sc.nextDouble();
        System.out.println("Enter interest rate:");
        interestrate=sc.nextDouble();
		double interest = balance * (interestrate / 100);
        balance = balance+ interest;
        System.out.println("Balance with Interest: " + interest);
    }
	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		
	}
	
}
