package com.hexaware.exception;



public class InsufficientFundException extends Exception{
 public InsufficientFundException()
 {
	 System.out.println("insufficient fund constructor");
 }
 public String toString()
 {
		return "From ife toString()";
	}
}
