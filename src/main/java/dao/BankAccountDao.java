package dao;

import java.util.List;

import model.BankAccountPojo;

public interface BankAccountDao {
	BankAccountPojo addAccount(BankAccountPojo productPojo); //create
	BankAccountPojo login(BankAccountPojo productPojo);
	BankAccountPojo updateAccount(BankAccountPojo productPojo); //update
	void deleteAccount(int productId); // delete
	List<BankAccountPojo> getAllBankAccounts();//read 
	BankAccountPojo getAnAccountById(int productId);//read
	BankAccountPojo addFunds(int funds, String accountType);// updates
	BankAccountPojo withdrawalFunds(int funds, String accountType);//updates
	BankAccountPojo getAnAccountByUsername(String username);//read
	
	
	
}
