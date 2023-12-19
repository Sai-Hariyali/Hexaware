package com.hexaware.controller;

import com.hexaware.entity.Customer;

public interface IBankServiceProvider {
public void create_account(Customer customer,long accountnumber,String accountype,double balance);
public void listAccounts();
public void getAccountDetails(long accountnumber);
public void calculateInterest();
}
