package presentation;

import java.util.Scanner;

import service.BankAccountServiceImpl;

public class BankSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
Scanner scan = new Scanner(System.in);
String input;

BankAccountServiceImpl service = new BankAccountServiceImpl();
		char proceed = 'y';
		while(proceed== 'y') {
		System.out.println("-----------------------");
		System.out.println("Welcome to our bank");
		System.out.println("-----------------------");
		System.out.println("1. Register an account");
		System.out.println("2. Login to existing account");
		System.out.println("3. Make a deposite");
		System.out.println("4. make a withdrawl");
		System.out.println("5. Check Balance from account");
		System.out.println("6. Logout of current account");
		System.out.println("7. Quit bank management system");
		
		System.out.println("-----------------------");
		System.out.println("Please enter an option");
		int option = scan.nextInt();
		System.out.println("-----------------------");
		
		switch(option) {
		case 1:
			String userInputs1[] = new String[2];
			System.out.println("-----------------------");
			System.out.println("Please input your username.");
			System.out.println("-----------------------");
			input = scan.next().toString();
			userInputs1[0] = input;
			
			
			
			System.out.println(input);
			System.out.println("-----------------------");
			System.out.println("Please input your password.");
			System.out.println("-----------------------");
			input = scan.next().toString();
			userInputs1[1] = input;
			System.out.println(service.addAccount(userInputs1[0], userInputs1[1]));
			System.out.println("continue? y or n");
			proceed = scan.next().charAt(0);
			break;

			
		case 2:
			String userInputs2[] = new String[2];
			System.out.println("-----------------------");
			System.out.println("Please input your username.");
			System.out.println("-----------------------");
			input = scan.next().toString();
			userInputs2[0] = input;
			
			
			
			System.out.println(input);
			System.out.println("-----------------------");
			System.out.println("Please input your password.");
			System.out.println("-----------------------");
			input = scan.next().toString();
			userInputs2[1] = input;
			
			System.out.println(userInputs2[0]);
			System.out.println(userInputs2[1]);
			System.out.println(service.login(userInputs2[0], userInputs2[1]));
			proceed = scan.next().charAt(0);
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			System.out.println("-----------------------");
			System.out.println("Thank you for using bank account manager");
			System.out.println("-----------------------");
			System.exit(0);
			default:
			break;
		}
		}
		
		

		

	}

}
