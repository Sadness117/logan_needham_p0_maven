package service;

import java.util.List;

import dao.BankAccountDao;
import dao.BankAccountDaoDatabaseImpl;
import exceptions.IncorrectUsernameOrPasswordException;
import model.BankAccountPojo;


public class BankAccountServiceImpl implements BankAccountService {

	BankAccountDao bankAccountDao;
	BankAccountPojo currUser;
	BankAccountDaoDatabaseImpl bankAccountDaoDatabaseImpl;
	public BankAccountServiceImpl(){
		bankAccountDaoDatabaseImpl = new BankAccountDaoDatabaseImpl();
	}
	@Override
	public BankAccountPojo addFunds(int funds, String accountType) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public BankAccountPojo withdrawalFunds(int funds, String accountType) {
		// TODO Auto-generated method stub
		return null;
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

}
