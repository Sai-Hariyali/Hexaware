package com.hexaware.assignments;
import java.util.Scanner;
public class AccountBalance4 {

	    public static void main(String[] args) {
	    	String ch="";
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the number of accounts: ");
	        int numberOfAccounts = scanner.nextInt();
	        int[] accountNumbers = new int[numberOfAccounts];
	        int[] accountBalances = new int[numberOfAccounts];
	        for (int i = 0; i<numberOfAccounts; i++) 
	        {
	            System.out.print("Enter account number for account:"+" " + (i + 1));
	            accountNumbers[i] = scanner.nextInt();
	            System.out.print("Enter balance for account:" +" "+ (i + 1));
	            accountBalances[i] = scanner.nextInt();
	        }
	        System.out.println("Account Information:");
	        for (int i = 0; i < numberOfAccounts; i++)
	        {
	            System.out.println("Account"+(i+1)+" "+"Number:"+" " +accountNumbers[i] +", Balance:" + accountBalances[i]);
	        }  
	        int i=0;
	       do{
	    	   System.out.print("Enter account number for balance check: ");
		        int searchAccount = scanner.nextInt();
	            if (accountNumbers[i] == searchAccount)
	            {
	                System.out.println("Account balance for account " + searchAccount + ": " + accountBalances[i]);
	            }
	            else
	            {
	            	System.out.println("Invalid account number");
	            }
	            System.out.println("Do you want to continue? Y | y");
				 ch = scanner.next();
				 i++;
	        }while(ch.equals("Y") || ch.equals("y"));
	       scanner.close();
	    }
}
