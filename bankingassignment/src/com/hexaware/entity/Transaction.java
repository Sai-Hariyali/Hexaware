package com.hexaware.entity;

import java.sql.Date;

public class Transaction {
private Account account;
private String description;
private Date dateandtime;
private double transactionamount;

public Account getAccount() {
	return account;
}
public void setAccount(Account account) {
	this.account = account;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getDateandtime() {
	return dateandtime;
}
public void setDateandtime(Date dateandtime) {
	this.dateandtime = dateandtime;
}
public double getTransactionamount() {
	return transactionamount;
}
public void setTransactionamount(double transactionamount) {
	this.transactionamount = transactionamount;
}
public Transaction(Account account, String description, Date dateandtime, double transactionamount) {
	super();
	this.account = account;
	this.description = description;
	this.dateandtime = dateandtime;
	this.transactionamount = transactionamount;
}
public Transaction() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Transaction [account=" + account + ", description=" + description + ", dateandtime=" + dateandtime
			+ ", transactionamount=" + transactionamount + "]";
}



}
