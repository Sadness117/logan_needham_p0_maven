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
	int addFunds(int funds, String accountType, BankAccountPojo currUser);// updates
	int withdrawalFunds(int funds, String accountType, BankAccountPojo currUser);//updates
	BankAccountPojo getAnAccountByUsername(String username);//read
	int checkFunds (String accountType, BankAccountPojo currUser);// read
	int transferFunds(String fromAccount, int funds, String toAccount, BankAccountPojo currUser);
	
	
}
