package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import model.BankAccountPojo;

public class BankAccountDaoDatabaseImpl implements BankAccountDao{
	
	
	@Override
	public boolean addAccount(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn;
		BankAccountPojo bankAccountPojo = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO accounts(username, hashed_password, checking, reserve, savings) VALUES ('"+username+"', '"+password+"', "+0+", "+0+", "+0+")";
			int rowsAffected = stmt.executeUpdate(query);
			ResultSet result = stmt.getGeneratedKeys();
			result.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
	}

	@Override
	public BankAccountPojo login(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn;
		BankAccountPojo bankAccountPojo = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM accounts WHERE username = " + "'" + username+ "'";
			
			
			ResultSet result = stmt.executeQuery(query);
			result.next();
			if (result.getString(3).equals(password)) {
				System.out.println("correct password");
				bankAccountPojo = new BankAccountPojo(result.getString(2), result.getString(3), result.getInt(1), result.getInt(4), result.getInt(5), result.getInt(6));
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bankAccountPojo;
	}

	@Override
	public BankAccountPojo updateAccount(BankAccountPojo bankAccountPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BankAccountPojo> getAllBankAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountPojo getAnAccountById(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountPojo addFunds(int funds, String accountType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountPojo withdrawalFunds(int funds, String accountType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountPojo getAnAccountByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
