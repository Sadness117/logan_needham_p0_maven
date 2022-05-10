package service;

import java.util.List;

import dao.BankAccountDao;
import dao.BankAccountDaoCollectionImpl;
import model.BankAccountPojo;


public class BankAccountServiceImpl implements BankAccountService {

	BankAccountDao bankAccountDao;
	public BankAccountServiceImpl(){
		bankAccountDao = new BankAccountDaoCollectionImpl(); 
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
	public BankAccountPojo addAccount(String username, String password) {
		// TODO Auto-generated method stub
		// referenced https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java
		int randomNum = (int)Math.floor(Math.random()*(1000-1+1)+1);
		BankAccountPojo newBankAccount= new BankAccountPojo(username, password, randomNum);
		BankAccountDaoCollectionImpl bankAccountDaoCollectionImpl = new BankAccountDaoCollectionImpl();
		bankAccountDaoCollectionImpl.addAccount(newBankAccount);
		return null;
	}

	public String login(String username, String password) {
		// TODO Auto-generated method stub
		//continue to check if correct password
		BankAccountDaoCollectionImpl bankAccountDaoCollectionImpl = new BankAccountDaoCollectionImpl();
		BankAccountPojo foundUser = bankAccountDaoCollectionImpl.getAnAccountByUsername(username);
		if(foundUser.checkPass(password)) {
			bankAccountDaoCollectionImpl.login(foundUser);
			return "Logged in as " + username;
		}else {
			return "incorrect password";
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
