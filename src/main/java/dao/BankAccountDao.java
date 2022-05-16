package dao;

import java.sql.SQLException;
import java.util.List;

import exceptions.notEnoughFundsException;
import model.BankAccountPojo;

public interface BankAccountDao {
	boolean addAccount(String username,String password)throws SQLException; //create
	BankAccountPojo login(String username, String password);
	double addFunds(double funds, String accountType, BankAccountPojo currUser);// updates
	double withdrawalFunds(double funds, String accountType, BankAccountPojo currUser) throws notEnoughFundsException;//updates
	double checkFunds (String accountType, BankAccountPojo currUser);// read
	double transferFunds(String fromAccount, double funds, String toAccount, BankAccountPojo currUser);
	
	
}
