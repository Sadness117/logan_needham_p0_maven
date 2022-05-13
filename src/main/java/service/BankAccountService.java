package service;

import java.util.List;

import model.BankAccountPojo;

public interface BankAccountService {
	String addAccount(String username, String password); //create
	BankAccountPojo updateAccount(BankAccountPojo bankAccountPojo); //update
	void deleteAccount(int productId); // delete
	List<BankAccountPojo> getAllBankAccounts();//read 
	BankAccountPojo getAnAccount(int productId);//read
	String addFunds(double funds, String accountType);// updates
	String withdrawalFunds(double funds, String accountType);//updates
	BankAccountPojo getId();//read
	String login(String username, String password); //create
	String checkFunds(String accountType);//read
	String logout(String input);//update
	String transferFunds(String fromAccount, double funds, String toAccount);//update
}
