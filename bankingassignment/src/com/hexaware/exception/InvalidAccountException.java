package com.hexaware.exception;

public class InvalidAccountException extends Exception{
	 public InvalidAccountException() {
		 System.out.println("account is invalid");
	 }
	 public String toString()
	 {
			return "From iae toString()";
		}
}
