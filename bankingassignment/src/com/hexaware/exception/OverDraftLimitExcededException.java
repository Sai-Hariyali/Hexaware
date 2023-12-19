package com.hexaware.exception;

public class OverDraftLimitExcededException extends Exception{
	public OverDraftLimitExcededException()
	{
		System.out.println("withdrawing from current account");
	}
	 public String toString()
	 {
			return "From ife toString()";
		}
}
