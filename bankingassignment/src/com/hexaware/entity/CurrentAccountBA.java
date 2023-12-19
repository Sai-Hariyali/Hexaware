package com.hexaware.entity;
import java.util.Scanner;
import com.hexaware.controller.BankAccountInterface;

public class CurrentAccountBA implements BankAccountInterface {
	private static double overdraftlimit=-1000;
	Scanner sc=new Scanner(System.in);
	public double getOverdraftlimit() {
		return overdraftlimit;
	}
	public CurrentAccountBA() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CurrentAccountBA(int accountnumber, String customername, double balance, double overdraftlimit) {
		this.overdraftlimit = overdraftlimit;
	}	
	@Override
    public void withdraw(double amount) {
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
	public void deposit(double amount) {
		// TODO Auto-generated method stub
	}

	@Override
	public void calculateInterest() {
		// TODO Auto-generated method stub
	}
}
