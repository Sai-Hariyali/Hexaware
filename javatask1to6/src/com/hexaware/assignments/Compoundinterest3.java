package com.hexaware.assignments;

import java.util.Scanner;
//Task 3: Loop Structures
public class Compoundinterest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int initialbalance=0, numberofyears=0,numberofcustomers=0;
		double futurebalance=0,annualinterestrate=0;
		Scanner scanner = new Scanner (System.in); 
		System.out.println("Enter number of customers :");
		numberofcustomers=scanner.nextInt();
		for(int i =1;i<=numberofcustomers;i++)
		{
			System.out.println("Customer No. : "+ i);
		System.out.println("Enter initial balance :");
		initialbalance=scanner.nextInt();
		System.out.println("Enter annual interest rate :");
		annualinterestrate=scanner.nextDouble();
		System.out.println("Enter number of years :");
		numberofyears=scanner.nextInt();
			futurebalance = initialbalance * Math.pow((1 + annualinterestrate/100),numberofyears);
			System.out.println(futurebalance);
		}
		scanner.close();
	}

}
