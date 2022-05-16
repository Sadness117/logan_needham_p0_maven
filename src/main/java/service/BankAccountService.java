package service;

import java.sql.SQLException;
import java.util.List;

import exceptions.notEnoughFundsException;
import model.BankAccountPojo;

public interface BankAccountService {
	String addAccount(String username, String password)throws Exception ; //create
	String addFunds(double funds, String accountType);// updates
	String withdrawalFunds(double funds, String accountType)throws notEnoughFundsException;//updates
	String login(String username, String password); //create
	String checkFunds(String accountType);//read
	String logout(String input);//update
	String transferFunds(String fromAccount, double funds, String toAccount);//update
}
