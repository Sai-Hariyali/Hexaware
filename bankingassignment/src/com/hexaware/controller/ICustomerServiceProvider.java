package com.hexaware.controller;

import java.util.Date;

public interface ICustomerServiceProvider {
public void get_account_balance(long accountnumber);
public void deposit(long accountnumber,double amount);
public void withdraw(long accountnumber,double amount);
public void transfer(long fromaccountnumber,long toaccountnumber,double amount);
public void getAccountDetails(long accountnumber);
public void getTransactions(long accountnumber,Date fromdate,Date todate);
}
