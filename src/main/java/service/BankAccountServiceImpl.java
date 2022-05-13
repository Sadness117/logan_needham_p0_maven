package service;

import java.util.List;

import dao.BankAccountDao;
import dao.BankAccountDaoDatabaseImpl;

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
		if (currUser == null) {
			return "You must login first";
		} else {
			double result = bankAccountDaoDatabaseImpl.addFunds(funds, accountType, currUser);
			return result + " funds added";
		}
	}

	
	public String withdrawalFunds(double funds, String accountType) {
		// TODO Auto-generated method stub
		if (currUser == null) {
			return "You must login first";
		} else {
			double result = bankAccountDaoDatabaseImpl.addFunds(funds, accountType, currUser);
			return result + " withdrawn";
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
		String hashed = bankAccountDaoDatabaseImpl.hashPassword(password);
		
		boolean bankAccountPojo = bankAccountDaoDatabaseImpl.addAccount(username, hashed);

		return "Account Successfully added, welcome " + username;
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

	
	public BankAccountPojo updateAccount(BankAccountPojo productPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void deleteAccount(int productId) {
		// TODO Auto-generated method stub

	}


	public List<BankAccountPojo> getAllBankAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public BankAccountPojo getAnAccount(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String checkFunds(String accountType) {
		double currFunds = bankAccountDaoDatabaseImpl.checkFunds(accountType, currUser);
		return "$" + currFunds + " in " + accountType;
	}

	public String logout(String input) {
		// TODO Auto-generated method stub
		if (input.equals("y")) {
			currUser = null;
			return "Sucessfully logged out";
		} else {
			return "canceled logout";
		}

	}

	public String transferFunds(String fromAccount, double funds, String toAccount) {
		// TODO Auto-generated method stub
		if (currUser == null) {
			return "You must login first";
		} else {
			double status = bankAccountDaoDatabaseImpl.transferFunds(fromAccount, funds, toAccount, currUser);
			return "$" + status + "transfered";
		}
	}
}
