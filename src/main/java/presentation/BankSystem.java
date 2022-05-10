package presentation;

import java.util.Scanner;

import service.BankAccountServiceImpl;

public class BankSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
Scanner scan = new Scanner(System.in);
String input;

BankAccountServiceImpl service = new BankAccountServiceImpl();
		System.out.println("-----------------------");
		System.out.println("Welcome to our bank");
		System.out.println("-----------------------");
		System.out.println("1. Register an account");
		System.out.println("2. Login to existing account");
		System.out.println("3. Make a deposite");
		System.out.println("4. make a withdrawl");
		System.out.println("5. Check Balance from account");
		System.out.println("6. Logout");
		
		System.out.println("-----------------------");
		System.out.println("Please enter an option");
		int option = scan.nextInt();
		System.out.println("-----------------------");
		
		switch(option) {
		case 1:
			
			break;
			
		case 2:
			String userInputs[] = new String[2];
			System.out.println("-----------------------");
			System.out.println("Please input your username.");
			System.out.println("-----------------------");
			input = scan.next().toString();
			userInputs[0] = input;
			
			
			
			System.out.println(input);
			System.out.println("-----------------------");
			System.out.println("Please input your password.");
			System.out.println("-----------------------");
			input = scan.next().toString();
			userInputs[1] = input;
			
			System.out.println(userInputs[0]);
			System.out.println(userInputs[1]);
			System.out.println(service.login(userInputs[0], userInputs[1]));
			
			break;
		case 3:
			break;
		case 4:
			break;
			default:
		}
		
		
		

		

	}

}
