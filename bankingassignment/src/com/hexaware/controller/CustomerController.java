package com.hexaware.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.CustomerDao;
import com.hexaware.entity.Customer;

public class CustomerController implements CustomerInterface{
	Customer customer;
	Scanner scanner = new Scanner(System.in);
	List  customerlist = new ArrayList();
	CustomerDao customerdao ;
	
	@Override
	public void addCustomer() {
		// TODO Auto-generated method stub
		customer = new Customer();
		customerdao= new CustomerDao();
		System.out.println("Enter customer id:");
		int cid=scanner.nextInt();
		customer.setCustomerid(cid);
		System.out.println("Enter first name:");
		String firstname=scanner.next();
		customer.setFirstname(firstname);
		System.out.println("Enter last name:");
		String lastname=scanner.next();
		customer.setLastname(lastname);
		System.out.println("Enter date of birth:");
		String dateofbirth=scanner.next();
		customer.setDateofbirth(dateofbirth);
		System.out.println("Enter email:");
		String emailaddress=scanner.next();
		customer.setEmailaddress(emailaddress);
		System.out.println("Enter phone number:");
		long phonenumber=scanner.nextLong();
		customer.setPhonenumber(phonenumber);
		System.out.println("Enter address:");
		String address=scanner.next();
		customer.setAddress(address);
		customerdao.insertCustomer(customer);
		System.out.println("Customer added successfully");
	}

	@Override
	public void viewCustomer() {
		// TODO Auto-generated method stub
		customerdao.showCustomer();
	}

}
