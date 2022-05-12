package service;

import java.util.List;

import dao.BankAccountDao;
import dao.BankAccountDaoDatabaseImpl;

import model.BankAccountPojo;


public class BankAccountServiceImpl implements BankAccountService {

	BankAccountDao bankAccountDao;
	BankAccountPojo currUser;
	BankAccountDaoDatabaseImpl bankAccountDaoDatabaseImpl;
	public BankAccountServiceImpl(){
		bankAccountDaoDatabaseImpl = new BankAccountDaoDatabaseImpl();
	}
	@Override
	public String addFunds(int funds, String accountType) {
		// TODO Auto-generated method stub
		int result = bankAccountDaoDatabaseImpl.addFunds(funds, accountType, currUser);
		return result + " funds added";
	}

	@Override
	public String withdrawalFunds(int funds, String accountType) {
		// TODO Auto-generated method stub
		int result = bankAccountDaoDatabaseImpl.addFunds(funds, accountType, currUser);
		return result + " withdrawn";
	}

	@Override
	public BankAccountPojo getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addAccount(String username, String password) {
		// TODO Auto-generated method stub
		// referenced https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java
		
		boolean bankAccountPojo= bankAccountDaoDatabaseImpl.addAccount(username, password);
		
		return "Account Successfully added, welcome " + username;
	}

	public String login(String username, String password){
		// TODO Auto-generated method stub
		//continue to check if correct password
		BankAccountPojo bankAccountPojo= bankAccountDaoDatabaseImpl.login(username, password);
		if(bankAccountPojo != null) {
			currUser = bankAccountPojo;
			return "Logged in";
		} else {
			return "incorrect username or password";
		}
		
		
		
	}
	@Override
	public BankAccountPojo updateAccount(BankAccountPojo productPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BankAccountPojo> getAllBankAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountPojo getAnAccount(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
	public String checkFunds(String accountType) {
		int currFunds = bankAccountDaoDatabaseImpl.checkFunds(accountType, currUser);
		return "$"+ currFunds +" in " + accountType;
	}
	@Override
	public String logout(String input) {
		// TODO Auto-generated method stub
		if(input.equals("y")) {
			currUser = null;
			return "Sucessfully logged out";
		}else {
			return "canceled logout";
		}
		
	}
	@Override
	public String transferFunds(String fromAccount, int funds, String toAccount) {
		// TODO Auto-generated method stub
		int status = bankAccountDaoDatabaseImpl.transferFunds(fromAccount, funds, toAccount, currUser);
		return "$"+ status+"transfered";
	}
}
