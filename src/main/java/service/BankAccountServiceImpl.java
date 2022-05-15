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

	public BankAccountServiceImpl() {
		bankAccountDaoDatabaseImpl = new BankAccountDaoDatabaseImpl();
	}

	public String addFunds(double funds, String accountType) {
		// TODO Auto-generated method stub
		if (funds<=0) {
			return "funds must be greater than $0";
		}
		if(accountType.equals("checking") || accountType.equals("reserve") || accountType.equals("savings")) {
			double result = bankAccountDaoDatabaseImpl.addFunds(funds, accountType, currUser);
			return result + " funds added";
			
		}
		return "Invalid account type.";
		

	}

	public String withdrawalFunds(double funds, String accountType){
		// TODO Auto-generated method stub
		if (funds<=0) {
			return "funds must be greater than $0";
		}
		if(accountType.equals("checking") || accountType.equals("reserve") || accountType.equals("savings")) {
			try {
			double result = bankAccountDaoDatabaseImpl.withdrawalFunds(funds, accountType, currUser);
			return result + " withdrawn";
			}
			catch(Exception e){
				return notEnoughFundsException.Message(accountType);
			}
			
		} else {
			return "Invalid account type.";
		}
	}

	public BankAccountPojo getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String addAccount(String username, String password) {
		// TODO Auto-generated method stub
		// referenced
		// https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java
		try {
		String hashed = bankAccountDaoDatabaseImpl.hashPassword(password);

		boolean bankAccountPojo = bankAccountDaoDatabaseImpl.addAccount(username, hashed);

		return "Account Successfully added, welcome " + username;
		}
		catch(SQLException e){
			return e.getLocalizedMessage();
		}
		
	}

	public String login(String username, String password) {
		// TODO Auto-generated method stub
		// continue to check if correct password
		BankAccountPojo bankAccountPojo = bankAccountDaoDatabaseImpl.login(username, password);
		if (bankAccountPojo != null) {
			currUser = bankAccountPojo;
			return "Logged in";
		} else {
			return "incorrect username or password";
		}

	}

	public String checkFunds(String accountType) {
		if(accountType.equals("checking") || accountType.equals("reserve") || accountType.equals("savings")) {
			double currFunds = bankAccountDaoDatabaseImpl.checkFunds(accountType, currUser);
			return "$" + currFunds + " in " + accountType;
			
			
		}
		return "Invalid account type.";

	}

	public String logout(String input) {
		// TODO Auto-generated method stub
		if (currUser == null) {
			return "nothing to logout of.";
		}
		if (input.equals("y")) {
			currUser = null;
			return "Sucessfully logged out";
		} else {
			return "canceled logout";
		}

	}

	public String transferFunds(String fromAccount, double funds, String toAccount) {
		// TODO Auto-generated method stub
		if (funds<=0) {
			return "funds must be greater than $0";
		}
		if (!fromAccount.equals("checking") || !fromAccount.equals("reserve") || !fromAccount.equals("savings")) {
			return "Invalid account type.";
		}
		if (!toAccount.equals("checking") || !toAccount.equals("reserve") || !toAccount.equals("savings")) {
			return "Invalid account type.";
		}
		double status = bankAccountDaoDatabaseImpl.transferFunds(fromAccount, funds, toAccount, currUser);
		return "$" + status + "transfered";

	}

	public boolean checkLoggedIn() {
		if (currUser == null) {
			return false;
		} else {
			return true;
		}
	}
}
