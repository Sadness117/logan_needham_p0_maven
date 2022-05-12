package service;

import java.util.List;

import model.BankAccountPojo;

public interface BankAccountService {
	String addAccount(String username, String password); //create
	BankAccountPojo updateAccount(BankAccountPojo bankAccountPojo); //update
	void deleteAccount(int productId); // delete
	List<BankAccountPojo> getAllBankAccounts();//read 
	BankAccountPojo getAnAccount(int productId);//read
	String addFunds(int funds, String accountType);// updates
	String withdrawalFunds(int funds, String accountType);//updates
	BankAccountPojo getId();//read
	String login(String username, String password); //create
	String checkFunds(String accountType);//read
	String logout(String input);//update
	String transferFunds(String fromAccount, int funds, String toAccount);//update
}
