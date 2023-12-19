package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Account;
import com.hexaware.util.MyDBConnection;

public class AccountDao 
{
	Connection connection;
	Statement statement;
	PreparedStatement preparedstatement;
	ResultSet resultset;
	
	public void saveAccount(Account account) {
        try {
        	connection = MyDBConnection.getMyDbConnection();
            preparedstatement = connection.prepareStatement("insert into accounts"
            		+ " (account_number, account_type, account_balance, customer_id) values (?, ?, ?, ?)");

            preparedstatement.setLong(1, account.getAccountNumber());
            preparedstatement.setLong(2, account.getCustomer().getCustomerid()); 
            preparedstatement.setString(3, account.getAccounttype());
            preparedstatement.setDouble(4, account.getAccountbalance());

            int noofrows =preparedstatement.executeUpdate();
            System.out.println(noofrows+"inserted sucessfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
        public void showAccounts() 
        {
        	try {
        		connection = MyDBConnection.getMyDbConnection();
    			statement = connection.createStatement();
    			resultset = statement.executeQuery("select * from accounts");
    			while(resultset.next()) {
    				System.out.println("Account no.:"+resultset.getInt(1));
    				System.out.println("Customer id:"+resultset.getInt(2));
    				System.out.println("Account type:"+resultset.getString(3));
    				System.out.println("Account balance:"+resultset.getDouble(4));
    			}
        	}
    			catch (SQLException e) {
    				e.printStackTrace();
    			}
        	
        }
}
