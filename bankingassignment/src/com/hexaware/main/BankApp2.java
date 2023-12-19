package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.controller.BankController;
import com.hexaware.entity.Account;
import com.hexaware.entity.Customer;

public class BankApp2 {
public static void main(String[] args)
{
	BankController bankController = new BankController();
	Account account = new Account();
	Customer customer = new Customer();
    Scanner scanner = new Scanner(System.in);
    System.out.println("BANKING SYSTEM MENU");
    String ch = null;
    do {
    	System.out.println("1. create account");
        System.out.println("2. deposit");
        System.out.println("3. withdraw");
        System.out.println("4. get balance");
        System.out.println("5. transfer");
        System.out.println("6. getAccountDetails");
        System.out.println("7. list accounts");
        System.out.println("8. exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch(choice) {
        case 1:{
			bankController.createAccount(customer, account);
        	break;
        }
        case 2:{
        	bankController.deposit(0, 0);
        	break;
        }
        case 3:{
        	bankController.withdraw(0, 0);
        	break;
        }
        case 4:{
        	bankController.getAccountBalance(0);
        	break;
        }
        case 5:{
        	bankController.transfer(0, 0, 0);
        	break;
        }
        case 6:{
        	bankController.getAccountDetails(0);
        	break;
        }
        case 7:{
        	System.out.println("Exiting. Thank You.");
        	break;
        }
        default:{
        	System.out.println("Invalid choice");
        	break;
        }
        } 
        System.out.println("Do you want to continue? Y | y");
		ch = scanner.next(); 
    }while(ch.equals("Y") || ch.equals("y"));
    System.out.println("Thanks for using our system");
	scanner.close();
}
}
