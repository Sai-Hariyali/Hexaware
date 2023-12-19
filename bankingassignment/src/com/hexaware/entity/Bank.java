package com.hexaware.entity;
import java.util.Scanner;
import com.hexaware.controller.AccountController;
import com.hexaware.controller.AccountInterface;
import com.hexaware.controller.CurrentAccountController;
import com.hexaware.controller.SavingsAccountController;
public class Bank {
	public static void main(String[] args) {
		
		SavingsAccount savingsAccount = new SavingsAccount();
		CurrentAccount currentAccount = new CurrentAccount();
		SavingsAccountController savingsController = new SavingsAccountController();
		CurrentAccountController currentController = new CurrentAccountController();
		
		 System.out.println("BANKING SYSTEM MENU");
		 Scanner sc = new Scanner(System.in);
		 String ch = null;
		do{
			 System.out.println("1. Savings Account");
		     System.out.println("2. Current Account");
		     int choice = sc.nextInt();
		     switch (choice) {
		     case 1:
		     {
		    System.out.println("Enter savings account number:");
			int savingsaccountnumber = sc.nextInt();
		     System.out.println("Savings account created successfully. Account number is "+savingsaccountnumber);
		     System.out.println("1. Deposit 2. Withdraw 3. Calculate Interest");
		     int option=sc.nextInt();
		     if(option==1) {
		    	 savingsController.deposit(0.0);
		     }
		     else if(option==2) {
		    	 savingsController.withdraw(0.0);
		     }
		     else if(option==3) {
		    	 savingsController.calculateInterest();
		     }
		     else {
		    	 System.out.println("invalid option");
		     }
		     break;
		     }
		     
		     case 2:{
		   	System.out.println("Enter current account number:");
			int currentaccountnumber = sc.nextInt();
			  System.out.println("Current account created successfully. Account number is "+currentaccountnumber);
			  System.out.println("1. Deposit 2. Withdraw 3. Calculate Interest");
			  int option=sc.nextInt();
			     if(option==1) {
			    	 currentController.deposit(0.0);
			     }
			     else if(option==2) {
			    	 currentController.withdraw(0.0);
			     }
			     else if(option==3) {
			    	 currentController.calculateInterest();
			     }
			     else {
			    	 System.out.println("invalid option");
			     }
			  break;
		     }
		     }System.out.println("Do you want to continue? Y | y");
			ch = sc.next();
		}while(ch.equals("Y") || ch.equals("y"));
		System.out.println("Thanks for using our system");
		sc.close();
		
	}

}
