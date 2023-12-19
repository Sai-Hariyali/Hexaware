package com.hexaware.assignments;

import java.util.Scanner;
//Task 1: Conditional Statements
public class Loaneligibility1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int credit_score=0,annual_income=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter credit score: ");
		credit_score=sc.nextInt();
		System.out.println("Enter annual income: ");
		annual_income=sc.nextInt();
		if (credit_score > 700 && annual_income >= 50000)
		{
			System.out.println("congrats !! you are eligible for a loan");
		}
		else
		{
			System.out.println("sorry, you are not eligible for a loan");
		}
		sc.close();
	}

}
