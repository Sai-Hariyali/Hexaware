package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.controller.AccountController;
import com.hexaware.controller.AccountInterface;
import com.hexaware.controller.BankController;
import com.hexaware.controller.BankServiceProviderImpl;
import com.hexaware.controller.CustomerServiceProviderImpl;
import com.hexaware.entity.Account;
import com.hexaware.entity.Customer;
import com.hexaware.exception.InsufficientFundException;

public class BankApp {
private static long accountno;

public static void main(String[] args)
{
	BankServiceProviderImpl bankserviceproviderimpl = new BankServiceProviderImpl();
	CustomerServiceProviderImpl customerserviceproviderimpl = new CustomerServiceProviderImpl();
	
	Account account = new Account();
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
        try {
			switch(choice) {
			case 1:{
				System.out.println("Choose Account Type:");
			    System.out.println("1. Current Account");
			    System.out.println("2. Savings Account");
			    System.out.print("Enter your choice: ");
			    int accountChoice = scanner.nextInt();
			    if(accountChoice==1)
			    {
			    	System.out.print("Enter initial balance: ");
			        double initialBalance = scanner.nextDouble();
			        System.out.println("Enter customer id:");
			        int customerId = scanner.nextInt();
			        System.out.println("Enter first name:");
			        String firstName = scanner.next();
			        System.out.println("Enter last name:");
			        String lastName = scanner.next();
			        System.out.println("Enter email:");
			        String emailAddress = scanner.next();
			        System.out.println("Enter phone number:");
			        long phoneNumber = scanner.nextLong();
			        System.out.println("Enter address:");
			        String address = scanner.next();
			        System.out.println("Enter date of birth:");
			        String dateofbirth=scanner.next();
			        Customer customer = new Customer(customerId, firstName, lastName, emailAddress, phoneNumber, address,dateofbirth);
			        bankserviceproviderimpl.create_account(customer, accountno, "Current", initialBalance);
			    
			    }
			    else if(accountChoice==2)
			    {
			    	System.out.print("Enter initial balance: ");
			        double initialBalance = scanner.nextDouble();
			        System.out.println("Enter customer id:");
			        int customerId = scanner.nextInt();
			        System.out.println("Enter first name:");
			        String firstName = scanner.next();
			        System.out.println("Enter last name:");
			        String lastName = scanner.next();
			        System.out.println("Enter email:");
			        String emailAddress = scanner.next();
			        System.out.println("Enter phone number:");
			        long phoneNumber = scanner.nextLong();
			        System.out.println("Enter address:");
			        String address = scanner.next();
			        System.out.println("Enter date of birth:");
			        String dateofbirth=scanner.next();
			        Customer customer = new Customer(customerId, firstName, lastName, emailAddress, phoneNumber, address,dateofbirth);
			        bankserviceproviderimpl.create_account(customer, accountno, "Savings", initialBalance);
			    }
				else {
					System.out.println("Invalid option");
				}
				break;
			}
			case 2:{
				System.out.print("Enter Account Number for Deposit: ");
			    long depositAccountNumber = scanner.nextLong();
			    System.out.print("Enter Deposit Amount: ");
			    double depositAmount = scanner.nextDouble();
			    customerserviceproviderimpl.deposit(depositAccountNumber, depositAmount);
				break;
			}
			case 3:{
				System.out.print("Enter Account Number for Withdrawal: ");
			    long withdrawAccountNumber = scanner.nextLong();
			    System.out.print("Enter Withdraw Amount: ");
			    double withdrawAmount = scanner.nextDouble();
			    customerserviceproviderimpl.withdraw(withdrawAccountNumber, withdrawAmount);
				break;
			}
			case 4:{
				System.out.print("Enter Account Number: ");
			    long accountNumber = scanner.nextLong();
			    customerserviceproviderimpl.get_account_balance(accountNumber);
				break;
			}
			case 5:{
				System.out.print("Enter From Account Number: ");
			    long fromAccountNumber = scanner.nextLong();
			    System.out.print("Enter To Account Number: ");
			    long toAccountNumber = scanner.nextLong();
			    System.out.print("Enter Transfer Amount: ");
			    double transferAmount = scanner.nextDouble();
			    customerserviceproviderimpl.transfer(fromAccountNumber, toAccountNumber, transferAmount);
			    System.out.println("Transfer successful.");
				break;
			}
			case 6:{
				System.out.print("Enter Account Number: ");
			    long accountNumber = scanner.nextLong();
			    customerserviceproviderimpl.getAccountDetails(accountNumber);
				break;
			}
			case 7:{
				bankserviceproviderimpl.listAccounts();
				break;
			}
			case 8:{
				System.out.println("Exiting. Thank You.");
				break;
			}
			default:{
				System.out.println("Invalid choice");
				break;
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Do you want to continue? Y | y");
		ch = scanner.next(); 
    }while(ch.equals("Y") || ch.equals("y"));
    System.out.println("Thanks for using our system");
	scanner.close();
}
}
