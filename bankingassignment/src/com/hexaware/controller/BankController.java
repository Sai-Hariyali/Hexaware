package com.hexaware.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.hexaware.entity.Account;
import com.hexaware.entity.Customer;

public class BankController implements BankInterface {
	String ch=null;
	Scanner scanner = new Scanner(System.in);
	
	private Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
    private Map<Integer, Account> accounts = new HashMap<Integer, Account>();
    
    SavingsAccountController sac;
    AccountController ac=new AccountController();
    
public BankController(Map<Integer, Customer> customers, Map<Integer, Account> accounts) {
		super();
		this.customers = customers;
		this.accounts = accounts;
	}

public BankController() {
	super();
	// TODO Auto-generated constructor stub
}
	
	@Override
	public void createAccount(Customer customer, Account account)
	{
		System.out.println("Enter customer id:");
		int customerid=scanner.nextInt();
		customer.setCustomerid(customerid);
		System.out.println("Enter first name:");
		String firstname=scanner.next();
		customer.setFirstname(firstname);
		System.out.println("Enter last name:");
		String lastname=scanner.next();
		customer.setLastname(lastname);
		System.out.println("Enter email:");
		String emailaddress=scanner.next();
		customer.setEmailaddress(emailaddress);
		System.out.println("Enter phone number:");
		long phonenumber=scanner.nextLong();
		customer.setPhonenumber(phonenumber);
		System.out.println("Enter address:");
		String address=scanner.next();
		customer.setAddress(address);
        System.out.println("Enter account number:");
        int accountnumber=scanner.nextInt();
   	 	account.setAccountnumber(accountnumber);
   	 	System.out.println("Enter account type (savings or current):");
   	 	String accounttype=scanner.next();
   	 	account.setAccounttype(accounttype);
   	 	if(accounttype=="savings")
   	 	{
   	 		sac = new SavingsAccountController();
   	 		sac.calculateInterest();
   	 	}
   	 	System.out.println("Enter account balance:");
   	 	double accountbalance=scanner.nextDouble();
   	 	account.setAccountbalance(accountbalance);
   	 	customers.put(customerid, customer);
   	 	accounts.put(accountnumber, account);
   	 	System.out.println("account created successfully.");
   	 	displayCustomerDetails(customerid);
   	 	getAccountDetails(accountnumber);
	}
	
	
	public void displayCustomerDetails(int customerId) {
        Customer customer = customers.get(customerId);
        if (customer != null) {
            System.out.println("Customer Details:");
            System.out.println(customer);
        } else {
            System.out.println("Customer not found.");
        }
    }
	
@Override
    public void getAccountDetails(long accountnumber) {
    	System.out.println("Enter account number:");
    	int accountNumber=scanner.nextInt();
        Account foundAccount = accounts.get(accountNumber);
        if (foundAccount != null) {
            System.out.println("\nAccount Details:");
            System.out.println(foundAccount);
        } else {
            System.out.println("Account not found.");
        }
    }
    
	@Override
	public void getAccountBalance(long accountnumber) {
		// TODO Auto-generated method stub
		System.out.println("Enter account number:");
    	int accountNumber=scanner.nextInt();
		if (accounts.containsKey(accountNumber)) {
	        Account account = accounts.get(accountNumber);
	        System.out.println("Account Balance: " + account.getAccountbalance());
	    } else {
	        System.out.println("Account not found with the given account number.");
	    }
	}
	
	@Override
	public void transfer(long fromAccountNumber, long toAccountNumber, double amount) {
		// TODO Auto-generated method stub
		System.out.println("Enter from account number:");
		int fromaccountno = scanner.nextInt();
		Account fromAccount = accounts.get(fromaccountno);
		
		System.out.println("Enter to account number:");
		int toaccountno = scanner.nextInt();
		Account toAccount = accounts.get(toaccountno);
		
		System.out.println("Enter transfer amount:");
		int transferamount=scanner.nextInt();
		Account amounts =accounts.get(transferamount);
		
		if(accounts.containsKey(fromAccount) && accounts.containsKey(toAccount))
		{
			if(fromAccount.getAccountbalance()>=amounts.getAccountbalance())
			{
		fromAccount.setAccountbalance(fromAccount.getAccountbalance()-amounts.getAccountbalance());
		toAccount.setAccountbalance(toAccount.getAccountbalance()+amounts.getAccountbalance());
		
    	System.out.println("transfer successful");
    	 System.out.println("Source Account Details:");
         getAccountDetails(fromaccountno);
         System.out.println("Destination Account Details:");
         getAccountDetails(toaccountno);
			}
			else {
				System.out.println("Insufficient balance in the source account.");
			}
		}
		else {
	        System.out.println("One or both account numbers not found.");
	    }
	}
	
	
	@Override
	public void withdraw(long accountNumber, double amount) {
		// TODO Auto-generated method stub
		ac.withdraw(0.0);
	}

	@Override
	public void deposit(long accountNumber, double amount) {
		// TODO Auto-generated method stub
		ac.deposit(0.0);
	}

}
