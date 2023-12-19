package com.hexaware.exception;

public class NullPointerException extends Exception{
 public NullPointerException()
 {
	 System.out.println("null value");
 }
 public String toString()
 {
		return "From npe toString()";
	}
}
