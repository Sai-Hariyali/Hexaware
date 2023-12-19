package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Customer;
import com.hexaware.util.MyDBConnection;

public class CustomerDao {
	Connection connection;
	Statement statement;
	PreparedStatement preparedstatement;
	ResultSet resultset;
	
	public void insertCustomer(Customer customer) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			preparedstatement=connection.prepareStatement("insert into customers values(?,?,?,?,?,?,?)");
			preparedstatement.setInt(1, customer.getCustomerid());
			preparedstatement.setString(2,customer.getFirstname());
			preparedstatement.setString(3, customer.getLastname());
			preparedstatement.setString(4, customer.getDateofbirth());
			preparedstatement.setString(5, customer.getEmailaddress());
			preparedstatement.setLong(6, customer.getPhonenumber());
			preparedstatement.setString(7, customer.getAddress());
			int noofrows = preparedstatement.executeUpdate();
			System.out.println(noofrows+"inserted sucessfully");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void showCustomer() {
		try {
			connection = MyDBConnection.getMyDbConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from customers");
			while (resultset.next()) {
				System.out.println("Customer id  : " + resultset.getInt(1));
				System.out.println("First name  : " + resultset.getString(2));
				System.out.println("Last name :"+resultset.getString(3) );
				System.out.println("Date of birth :"+resultset.getString(4));
				System.out.println("Email :"+resultset.getString(5));
				System.out.println("Phone :"+resultset.getLong(6));
				System.out.println("Address :"+resultset.getString(7));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}	
	}
}
