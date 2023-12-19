package com.hexaware.assignments;
import java.util.Scanner;
//Task 2: Nested Conditional Statements
public class Atmtransaction2 {
	    public static void main(String[] args) {
	    	int balance=0,choice=0,withdraw=0,deposit=0;
	        Scanner scanner = new Scanner(System.in);
	        	String ch = "";
	        	System.out.println("Welcome.");
	        do{
	        System.out.print("Enter balance: ");
	        balance = scanner.nextInt();
	        System.out.println("Choose an option:");
	        System.out.println("1. Check Balance");
	        System.out.println("2. Withdraw");
	        System.out.println("3. Deposit");
	        System.out.print("Enter your choice: ");
	        choice = scanner.nextInt();
	        if (choice == 1)  {
	            System.out.println("Your balance is: " + balance);
	        }	else if (choice == 2) {
	            System.out.print("Enter amount to withdraw: ");
	            withdraw= scanner.nextInt();
	            if (withdraw > balance){
	                System.out.println("Insufficient amount.");
	            }else if (withdraw % 100 != 0 && withdraw % 500 != 0){
	                System.out.println("Withdrawal amount must be in multiples of 100 or 500. Withdrawal failed.");
	            }else{
	                balance = balance - withdraw;
	                System.out.println("Rs. "+ withdraw + " withdrawn successfully. Remaining balance: " + balance);
	            }}else if (choice == 3){
	            System.out.print("Enter the amount to deposit: ");
	             deposit = scanner.nextInt();
	            if (deposit <= 0){
	                System.out.println("deposit amount invalid");
	            }else{
	                balance = balance + deposit;
	                System.out.println("Rs. "+ deposit+ " deposited successfully. Updated balance: " + balance);
	            }}else{
	            System.out.println("Invalid choice. Please choose a valid option (1, 2, or 3).");
	        }System.out.println("Do you want to continue? Y | y");
	        ch=scanner.next();
	        }while(ch.equals("Y") || ch.equals("y"));
	       System.out.println("Thank you.");
	        scanner.close();
	}
}
