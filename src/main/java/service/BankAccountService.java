package service;

import java.util.List;

import model.BankAccountPojo;

public interface BankAccountService {
	BankAccountPojo addAccount(String username, String password); //create
	BankAccountPojo updateAccount(BankAccountPojo bankAccountPojo); //update
	void deleteAccount(int productId); // delete
	List<BankAccountPojo> getAllBankAccounts();//read 
	BankAccountPojo getAnAccount(int productId);//read
	BankAccountPojo addFunds(int funds, String accountType);// updates
	BankAccountPojo withdrawalFunds(int funds, String accountType);//updates
	BankAccountPojo getId();//read
	String login(String username, String password); //create
}
