package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Transaction;
import com.hexaware.util.MyDBConnection;

public class TransactionDao {
	Connection connection;
	Statement statement;
	PreparedStatement preparedstatement;
	ResultSet resultset;
	
	public void insertTransaction(Transaction transaction) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			preparedstatement=connection.prepareStatement("insert into transactions values(?,?,?,?)");
			 	preparedstatement.setLong(1, transaction.getAccount().getAccountnumber());
	            preparedstatement.setDate(2, transaction.getDateandtime());
	            preparedstatement.setDouble(3, transaction.getTransactionamount());
	            preparedstatement.setString(4, transaction.getDescription());
		}catch(SQLException  e) {
			e.printStackTrace();
		}
	}
	
	public void showTransaction() {
		try {
			connection = MyDBConnection.getMyDbConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from transactions");
			while (resultset.next()) {
				System.out.println("Account no.:"+resultset.getLong(1));
				System.out.println("Transaction date:"+resultset.getDate(2));
				System.out.println("Amount:"+resultset.getDouble(3));
				System.out.println("Description:"+resultset.getString(4));
			}
		}
		catch (SQLException e) {

			e.printStackTrace();
		}	
	}
}
