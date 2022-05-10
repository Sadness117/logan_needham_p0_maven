package dao;

import java.util.List;


import model.BankAccountPojo;

public interface BankAccountDao {
	boolean addAccount(String username,String password); //create
	BankAccountPojo login(String username, String password);
	BankAccountPojo updateAccount(BankAccountPojo bankAccountPojo); //update
	void deleteAccount(int productId); // delete
	List<BankAccountPojo> getAllBankAccounts();//read 
	BankAccountPojo getAnAccountById(int accountId);//read
	BankAccountPojo addFunds(int funds, String accountType);// updates
	BankAccountPojo withdrawalFunds(int funds, String accountType);//updates
	BankAccountPojo getAnAccountByUsername(String username);//read
	
	
	
}
