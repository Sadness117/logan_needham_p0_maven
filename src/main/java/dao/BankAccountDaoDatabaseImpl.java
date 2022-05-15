package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import exceptions.notEnoughFundsException;
import model.BankAccountPojo;

public class BankAccountDaoDatabaseImpl implements BankAccountDao{
	
	
	public String hashPassword(String password) {
		String hashedPass = BCrypt.hashpw(password, BCrypt.gensalt(10));
		
		return hashedPass;
	}
	public boolean checkPass(String password, String hashedPass) {
		if (BCrypt.checkpw(password, hashedPass)) {
			return true;
		} else {
			return false;
		}
	}
	public double transferFunds(String fromAccount, double funds, String toAccount, BankAccountPojo currUser) {
		Connection conn;
		BankAccountPojo bankAccountPojo = null;
		double startingAccount;
		double endingAccount;
		
		
		
		if(fromAccount.equals("checking")) {
			startingAccount = currUser.getChecking();
			
			
		}else if(fromAccount.equals("reserve")) {
			startingAccount = currUser.getReserve();
			
		}else if(fromAccount.equals("savings")) {
			startingAccount = currUser.getSavings();
			
		}else {
			return -0;
		}
		
		if(toAccount.equals("checking")) {
			endingAccount = currUser.getChecking();
			
			
		}else if(toAccount.equals("reserve")) {
			endingAccount = currUser.getReserve();
			
		}else if(toAccount.equals("savings")) {
			endingAccount = currUser.getSavings();
			
		}else {
			return -0;
		}
		
		if (startingAccount >= funds) {
			startingAccount -= funds;
			endingAccount += funds;
		}
		
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "UPDATE accounts SET " +fromAccount+" = "+startingAccount+", "+ toAccount+" = "+endingAccount +" WHERE username = " + "'" + currUser.getUsername()+ "'";
			
			int result = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return funds;
	}

	
	public boolean addAccount(String username, String password) throws SQLException{
		// TODO Auto-generated method stub
		Connection conn;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO accounts(username, hashed_password, checking, reserve, savings) VALUES ('"+username+"', '"+password+"', "+0+", "+0+", "+0+") returning id";
			ResultSet result = stmt.executeQuery(query);
			result.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SQLException(e);
		}
		
		return true;
		
	}

	
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
			boolean checkPassword= checkPass(password, result.getString(3));
			if (checkPassword == true) {
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

	
	public BankAccountPojo updateAccount(BankAccountPojo bankAccountPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void deleteAccount(int productId) {
		// TODO Auto-generated method stub
		
	}

	
	public List<BankAccountPojo> getAllBankAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public BankAccountPojo getAnAccountById(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public double addFunds(double funds, String accountType, BankAccountPojo currUser) {
		// TODO Auto-generated method stub
		Connection conn;
		double totalFunds;
		try {
			totalFunds = currUser.addFunds(funds, accountType);
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "UPDATE accounts SET " +accountType+" = "+totalFunds+" WHERE username = " + "'" + currUser.getUsername()+ "'";
			
			
			int result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return funds;
	}

	
	public double withdrawalFunds(double funds, String accountType, BankAccountPojo currUser) throws notEnoughFundsException {
		// TODO Auto-generated method stub
		
		Connection conn;
		double totalFunds;
		double initialFunds = 0;
		try {
			if(accountType.equals("checking")) {
				initialFunds = currUser.getChecking();
				
			}
			else if (accountType.equals("reserve")) {
				initialFunds = currUser.getReserve();
			}
			else if(accountType.equals("savings")) {
				initialFunds = currUser.getSavings();
			}
			totalFunds = initialFunds - funds; 
			
			
			if(totalFunds <0) {
				throw new notEnoughFundsException();
			}
			
			totalFunds = currUser.withdrawalFunds(funds, accountType);
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "UPDATE accounts SET " +accountType+" = "+totalFunds+" WHERE username = " + "'" + currUser.getUsername()+ "'";
			
			
			int result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return funds;
	}

	
	public double checkFunds(String accountType, BankAccountPojo currUser) {
		// TODO Auto-generated method stub
		if(accountType.equals("checking")) {
			return currUser.getChecking();
		} else if (accountType.equals("reserve")) {
			return currUser.getReserve();
		}else if (accountType.equals("savings")) {
			return currUser.getSavings();
		}else {
			return -1;
		}
		
	}

	
	public BankAccountPojo getAnAccountByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
