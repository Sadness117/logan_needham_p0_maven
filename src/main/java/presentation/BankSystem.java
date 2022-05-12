package presentation;

import java.util.Scanner;

import service.BankAccountServiceImpl;

public class BankSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
Scanner scan = new Scanner(System.in);
String input = null;
String accountType = null;
String userInputs[] = new String[2];
int funds;

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
		System.out.println("7. transfer funds from one account to another");
		System.out.println("8. Quit bank management system");
		
		System.out.println("-----------------------");
		System.out.println("Please enter an option");
		int option = scan.nextInt();
		System.out.println("-----------------------");
		
		switch(option) {
		case 1:
			
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
			System.out.println(service.addAccount(userInputs[0], userInputs[1]));
			System.out.println("continue? y or n");
			proceed = scan.next().charAt(0);
			break;

			
		case 2:
			
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
			System.out.println("-----------------------");
			System.out.println("Where would you like the funds to go?.");
			System.out.println("checking, reserve, savings");
			System.out.println("-----------------------");
			
			accountType = scan.next().toString();
			
			System.out.println("-----------------------");
			System.out.println("how much would you like to put in?");
			System.out.println("-----------------------");
			funds = scan.nextInt();
			System.out.println("-----------------------");
			System.out.println(service.addFunds(funds, accountType));
			System.out.println("-----------------------");
			System.out.println("continue? y or n");
			proceed = scan.next().charAt(0);
			break;
		case 4:
			System.out.println("-----------------------");
			System.out.println("Where would you like the funds withdrawn from?");
			System.out.println("checking, reserve, savings");
			System.out.println("-----------------------");
			
			accountType = null;
			accountType = scan.next().toString();
			
			System.out.println("-----------------------");
			System.out.println("how much would you like to withdrawal?");
			System.out.println("-----------------------");
			int funds1 = scan.nextInt();
			System.out.println("-----------------------");
			System.out.println(service.withdrawalFunds(funds1, accountType));
			System.out.println("-----------------------");
			System.out.println("continue? y or n");
			proceed = scan.next().charAt(0);
			break;
		case 5:
			System.out.println("-----------------------");
			System.out.println("What account would you like to check?");
			System.out.println("checking, reserve, savings");
			System.out.println("-----------------------");
			accountType = scan.next().toString();
			System.out.println("-----------------------");
			System.out.println(service.checkFunds(accountType));
			System.out.println("-----------------------");
			System.out.println("continue? y or n");
			proceed = scan.next().charAt(0);
			break;
		case 6:
			System.out.println("-----------------------");
			System.out.println("Logout of current account?");
			System.out.println("-----------------------");
			input = scan.next().toString();
			System.out.println(service.logout(input));
			System.out.println("-----------------------");
			System.out.println("continue? y or n");
			proceed = scan.next().charAt(0);
			
			break;
		case 7:
			System.out.println("-----------------------");
			System.out.println("What account would you like to transfer from?");
			System.out.println("checking, reserve, savings");
			System.out.println("-----------------------");
			input = scan.next().toString();
			userInputs[0]= input;
			System.out.println("-----------------------");
			System.out.println("How much would you like to transfer?");
			System.out.println("-----------------------");
			funds = scan.nextInt();
			
			System.out.println("-----------------------");
			System.out.println("What account would you like to transfer funds to?");
			System.out.println("checking, reserve, savings");
			System.out.println("-----------------------");
			input = scan.next().toString();
			userInputs[1]= input;
			
			
			System.out.println("-----------------------");
			System.out.println(service.transferFunds(userInputs[0], funds, userInputs[1]));
			System.out.println("-----------------------");
			
			
			
			
			break;
		case 8:
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
