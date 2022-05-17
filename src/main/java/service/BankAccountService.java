package service;

import java.sql.SQLException;
import java.util.List;

import exceptions.notEnoughFundsException;
import model.BankAccountPojo;

public interface BankAccountService {
	String addAccount(String username, String password)throws Exception ; //create
	String addFunds(double funds, String accountType, BankAccountPojo currUser);// updates
	String withdrawalFunds(double funds, String accountType, BankAccountPojo currUser)throws notEnoughFundsException;//updates
	BankAccountPojo login(String username, String password); //create
	String checkFunds(String accountType, BankAccountPojo currUser);//read
	String logout(String input, BankAccountPojo currUser);//update
	String transferFunds(String fromAccount, double funds, String toAccount,BankAccountPojo currUser);//update
}
