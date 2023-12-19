package com.hexaware.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.hexaware.dao.AccountDao;
import com.hexaware.dao.TransactionDao;
import com.hexaware.entity.Account;
import com.hexaware.entity.Customer;
public class FinalMain {
	public static void main(String[] args) throws SQLException {
		AccountDao accountdao = new AccountDao();		
		TransactionDao transactiondao = new TransactionDao();
		Scanner scanner = new Scanner(System.in);
		String ch=null;
		do {
			System.out.println("1.create account");
			System.out.println("2.get account details");
			System.out.println("3. get transactions");
			System.out.println("Enter choice:");
			int choice = scanner.nextInt();
	        switch(choice) {
	        case 1: {
	        	System.out.print("Enter account number: ");
	            long accountNumber = scanner.nextLong();
	            System.out.print("Enter account type: ");
	            String accountType = scanner.next();
	            System.out.print("Enter account balance: ");
	            double accountBalance = scanner.nextDouble();
	            System.out.print("Enter customer ID: ");
	            long customerId = scanner.nextLong();
	            Customer customer = null;
				Account account= new Account(accountNumber,accountType,accountBalance,customer);
	        	accountdao.saveAccount(account);
	        	break;
	        }
	        case 2: {
	        	accountdao.showAccounts();
	        	break;
	        }
	        case 3: {
	        	transactiondao.showTransaction();
	        	break;
	        }
	        default:{
	        	System.out.println("invalid option");
	        	break;
	        }
	        }System.out.println("Do you want to continue? Y | y");
	    	ch = scanner.next();
		}while(ch.equals("Y") || ch.equals("y"));
		System.out.println("Thanks for using our system");
		scanner.close();
	}

}
