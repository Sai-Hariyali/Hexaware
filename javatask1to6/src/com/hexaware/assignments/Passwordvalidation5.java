package com.hexaware.assignments;
import java.util.Scanner;
public class Passwordvalidation5 {
	public static void main(String[] args) {
       String ch="";
        Scanner scanner = new Scanner(System.in);
        do {
        System.out.println("Create a password for your bank account:");
        String password = scanner.next();
        if(password.length() >=8){
        	boolean hasUppercase = false;
        	for(int i=0;i<password.length();i++)
        	{
        		if(Character.isUpperCase(password.charAt(i)))
        		{
        			hasUppercase=true;
        			break;
        		}
        	}
        	boolean hasDigit = false;
            for (int i = 0; i < password.length(); i++)
            {
                if (Character.isDigit(password.charAt(i))) {
                    hasDigit = true;
                    break;
                }
            }
            if (hasUppercase && hasDigit) {
                System.out.println("Password is valid!");
            } else {
                System.out.println("Invalid password. "
                + "Please ensure it has at least one uppercase letter and one digit.");
            }	
        }
        else{
        	System.out.println("your password is invalid");
        	
        }
        System.out.println("Do you want to continue? Y | y");
		 ch = scanner.next();
        }while(ch.equals("Y") || ch.equals("y"));
        scanner.close();
	}
}
