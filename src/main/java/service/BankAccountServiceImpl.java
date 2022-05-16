package service;

import java.sql.SQLException;
import java.util.List;

import dao.BankAccountDao;
import dao.BankAccountDaoDatabaseImpl;
import exceptions.notEnoughFundsException;
import model.BankAccountPojo;

public class BankAccountServiceImpl implements BankAccountService {

	BankAccountDao bankAccountDao;
	BankAccountPojo currUser;
	BankAccountDaoDatabaseImpl bankAccountDaoDatabaseImpl;
// constructor for service layer
	public BankAccountServiceImpl() {
		bankAccountDaoDatabaseImpl = new BankAccountDaoDatabaseImpl();
	}
//adds funds to requested account
	public String addFunds(double funds, String accountType) {
	
		//checks if the funds are greater than 0
		if (funds<=0) {
			return "funds must be greater than $0";
		}
		//goes through account types, or returns invalid
		if(accountType.equals("checking") || accountType.equals("reserve") || accountType.equals("savings")) {
			double result = bankAccountDaoDatabaseImpl.addFunds(funds, accountType, currUser);
			return result + " funds added";
			
		}
		return "Invalid account type.";
		

	}

	//used to withdrawal funds
	public String withdrawalFunds(double funds, String accountType){
		// cant withdrawal negative funds
		if (funds<=0) {
			return "funds must be greater than $0";
		}
		//goes through account types, else returns invalid
		if(accountType.equals("checking") || accountType.equals("reserve") || accountType.equals("savings")) {
			try {
			double result = bankAccountDaoDatabaseImpl.withdrawalFunds(funds, accountType, currUser);
			return result + " withdrawn";
			}
			catch(Exception e){
				//catches the error for not enough funds
				return notEnoughFundsException.Message(accountType);
			}
			
		} else {
			return "Invalid account type.";
		}
	}

	//creates account
	public String addAccount(String username, String password) {
		// referenced
		// https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java
		try {
			//gets a hashed version of the password
		String hashed = bankAccountDaoDatabaseImpl.hashPassword(password);
		//adds account to database
		boolean bankAccountPojo = bankAccountDaoDatabaseImpl.addAccount(username, hashed);

		return "Account Successfully added, welcome " + username;
		}
		catch(SQLException e){
			//returns if the account username already exists
			return e.getLocalizedMessage();
		}
		
	}
//used to login
	public String login(String username, String password) {
		//calls data layer to login
		BankAccountPojo bankAccountPojo = bankAccountDaoDatabaseImpl.login(username, password);
		//if null means that the username or password input was incorrect
		if (bankAccountPojo != null) {
			currUser = bankAccountPojo;
			return "Logged in";
		} else {
			return "incorrect username or password";
		}

	}

	//checks funds of requested account type
	public String checkFunds(String accountType) {
		//goes through account types and if not a valid account it returns invalid
		if(accountType.equals("checking") || accountType.equals("reserve") || accountType.equals("savings")) {
			double currFunds = bankAccountDaoDatabaseImpl.checkFunds(accountType, currUser);
			return "$" + currFunds + " in " + accountType;
			
			
		}
		return "Invalid account type.";

	}
//logs out the user
	public String logout(String input) {
		
		//checks to see if a user is logged in already or not
		if (currUser == null) {
			return "nothing to logout of.";
		}
		//logs user out
		if (input.equals("y")) {
			currUser = null;
			return "Sucessfully logged out";
		} else {
			return "canceled logout";
		}

	}

	//transfer funds from one account to another
	public String transferFunds(String fromAccount, double funds, String toAccount) {
		
		//cant transfer 0 or less
		if (funds<=0) {
			return "funds must be greater than $0";
		}
		//checks account types and if not one it returns invalid
		if (fromAccount.equals("checking") || fromAccount.equals("reserve") || fromAccount.equals("savings")) {
			double status = bankAccountDaoDatabaseImpl.transferFunds(fromAccount, funds, toAccount, currUser);
			return "$" + status + "transfered";
			
		}
		return "Invalid account type.";
		

	}

	//checks if logged in
	public boolean checkLoggedIn() {
		//if there is no user it returns false else true
		if (currUser == null) {
			return false;
		} else {
			return true;
		}
	}
}
