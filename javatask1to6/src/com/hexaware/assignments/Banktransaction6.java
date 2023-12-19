package com.hexaware.assignments;
import java.util.ArrayList;
import java.util.Scanner;
public class Banktransaction6 {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int depositAmount=0;
	        String ch="";
	        ArrayList<String> bankTransaction = new ArrayList<>();
	        do {
	            System.out.println("\nSelect an option:");
	            System.out.println("1. Deposit");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Exit");
	            System.out.print("Enter your choice (1-3): ");
	            int choice = scanner.nextInt();
	            if(choice==1){
	                    System.out.print("Enter the deposit amount: ");
	                     depositAmount = scanner.nextInt();
	                     bankTransaction.add("Deposit: " + depositAmount);
	            }
	            else if(choice==2){
	                    System.out.print("Enter the withdrawal amount: ");
	                    int withdrawalAmount = scanner.nextInt();
	                    if (withdrawalAmount <= depositAmount){
	                    	bankTransaction.add("Withdrawal: " + withdrawalAmount);
	                    }else 
	                    {
	                        System.out.println("Insufficient funds. Withdrawal canceled.");
	                    }
	            }else if(choice== 3){
	                    System.out.println("Exiting.");
	            }else {
	                    System.out.println("Invalid choice. Please select a valid option.");
	            }
	            System.out.println("Do you want to continue? Y | y");
				ch = scanner.next();
	        } while (ch.equals("Y") || ch.equals("y"));
	        System.out.println("\nTransaction History:");
	        for (int i = 0; i < bankTransaction.size(); i++) {
	            System.out.println(bankTransaction.get(i));
	        }
	        scanner.close();}}

