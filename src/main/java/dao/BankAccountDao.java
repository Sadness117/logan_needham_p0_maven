package dao;

import java.sql.SQLException;
import java.util.List;

import exceptions.notEnoughFundsException;
import model.BankAccountPojo;

public interface BankAccountDao {
	boolean addAccount(String username,String password)throws SQLException; //create
	BankAccountPojo login(String username, String password);
	BankAccountPojo updateAccount(BankAccountPojo bankAccountPojo); //update
	void deleteAccount(int productId); // delete
	List<BankAccountPojo> getAllBankAccounts();//read 
	BankAccountPojo getAnAccountById(int accountId);//read
	double addFunds(double funds, String accountType, BankAccountPojo currUser);// updates
	double withdrawalFunds(double funds, String accountType, BankAccountPojo currUser) throws notEnoughFundsException;//updates
	BankAccountPojo getAnAccountByUsername(String username);//read
	double checkFunds (String accountType, BankAccountPojo currUser);// read
	double transferFunds(String fromAccount, double funds, String toAccount, BankAccountPojo currUser);
	
	
}
