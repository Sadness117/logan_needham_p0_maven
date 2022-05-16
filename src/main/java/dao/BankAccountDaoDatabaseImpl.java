package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import exceptions.notEnoughFundsException;
import model.BankAccountPojo;

public class BankAccountDaoDatabaseImpl implements BankAccountDao {
	// this class handles the database

	// hashes the users password
	public String hashPassword(String password) {
		// takes your password and returns an encrypted version of it
		String hashedPass = BCrypt.hashpw(password, BCrypt.gensalt(10));

		return hashedPass;
	}

	// checks the users password
	public boolean checkPass(String password, String hashedPass) {
		// takes your password and an encrypted password and compares it to see if its
		// the same values
		// as the password, if so it returns true
		if (BCrypt.checkpw(password, hashedPass)) {
			return true;
		} else {
			return false;
		}
	}

	// transfers the users requested funds from one account to another
	public double transferFunds(String fromAccount, double funds, String toAccount, BankAccountPojo currUser) {
		// initializes connection
		Connection conn;
		// initialize bankAccount Pojo
		BankAccountPojo bankAccountPojo = null;
		// startingAccount is the initial funds and the end account
		double startingAccount;
		double endingAccount;

		// if statement cycles through the fromAccount to see what funds are retrieved
		if (fromAccount.equals("checking")) {
			startingAccount = currUser.getChecking();

		} else if (fromAccount.equals("reserve")) {
			startingAccount = currUser.getReserve();

		} else if (fromAccount.equals("savings")) {
			startingAccount = currUser.getSavings();

		} else {
			return -0;
		}
		// if statement cycles through the toAccount to see what funds are retrieved
		if (toAccount.equals("checking")) {
			endingAccount = currUser.getChecking();

		} else if (toAccount.equals("reserve")) {
			endingAccount = currUser.getReserve();

		} else if (toAccount.equals("savings")) {
			endingAccount = currUser.getSavings();

		} else {
			return -0;
		}
		// checks if the starting account has enough funds to transfer and makes
		// the changes accordingly
		if (startingAccount >= funds) {
			startingAccount -= funds;
			endingAccount += funds;
		}

		try {
			// makes connection and creates statement
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			// transfer is an update query, nothing is created, updates the toAccount and
			// fromAccount
			String query = "UPDATE accounts SET " + fromAccount + " = " + startingAccount + ", " + toAccount + " = "
					+ endingAccount + " WHERE username = " + "'" + currUser.getUsername() + "'";

			int result = stmt.executeUpdate(query);

		} catch (SQLException e) {
			// catches any potential errors
			e.printStackTrace();
		}
		return funds;
	}

	// adds an account to the database
	public boolean addAccount(String username, String hashedPassword) throws SQLException {
		// initializes connection
		Connection conn;
		try {
			// creates connection to database
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			// this is a create query, takes the username, hashedPassword and creates an
			// account in the database
			// the checking, reserve, and savings is always passed through as 0 for the
			// first time
			String query = "INSERT INTO accounts(username, hashed_password, checking, reserve, savings) VALUES ('"
					+ username + "', '" + hashedPassword + "', " + 0 + ", " + 0 + ", " + 0 + ") returning id";
			ResultSet result = stmt.executeQuery(query);
			result.next();
		} catch (SQLException e) {
			// in case there is an account that already has the same username, throws error
			throw new SQLException(e);
		}
		// if successful, returns true
		return true;

	}

	// logs in a user to the application
	public BankAccountPojo login(String username, String password) {
		// initializes connection
		Connection conn;
		BankAccountPojo bankAccountPojo = null;
		try {
			// creates connection
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			// select query, searches for username and returns it if found
			String query = "SELECT * FROM accounts WHERE username = " + "'" + username + "'";

			ResultSet result = stmt.executeQuery(query);
			result.next();
			// takes the result and checks password with the retrieved hashed password
			boolean checkPassword = checkPass(password, result.getString(3));
			if (checkPassword == true) {
				// if correct password returns the user and their information
				System.out.println("correct password");
				bankAccountPojo = new BankAccountPojo(result.getString(2), result.getString(3), result.getInt(1),
						result.getInt(4), result.getInt(5), result.getInt(6));
			} else {
				return null;
			}
		} catch (SQLException e) {
			// would return user not found
			e.printStackTrace();
		}
		return bankAccountPojo;
	}

	// adds requested funds to a users account
	public double addFunds(double funds, String accountType, BankAccountPojo currUser) {
		// initializes connection and total funds
		Connection conn;
		double totalFunds;
		try {
			// takes the funds from the logged in user and ands the funds to the account
			totalFunds = currUser.addFunds(funds, accountType);
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			// updates the users account in the database with the correct funds to the
			// correct account
			String query = "UPDATE accounts SET " + accountType + " = " + totalFunds + " WHERE username = " + "'"
					+ currUser.getUsername() + "'";

			int result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// in case of error
			e.printStackTrace();
		}
		return funds;
	}

	// withdrawals requested funds for a user from an account
	public double withdrawalFunds(double funds, String accountType, BankAccountPojo currUser)
			throws notEnoughFundsException {
		// initializes connection, total funds,and initial funds

		Connection conn;
		double totalFunds;
		double initialFunds = 0;
		try {
			// cycles through the account types to get the correct starting funds
			if (accountType.equals("checking")) {
				initialFunds = currUser.getChecking();

			} else if (accountType.equals("reserve")) {
				initialFunds = currUser.getReserve();
			} else if (accountType.equals("savings")) {
				initialFunds = currUser.getSavings();
			}
			// total funds subtracts initial funds and funds
			totalFunds = initialFunds - funds;

			// checks if the total funds is below 0, can't overdraft
			// and throws an error
			if (totalFunds < 0) {
				throw new notEnoughFundsException();
			}
			// updates the curr users funds
			totalFunds = currUser.withdrawalFunds(funds, accountType);
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			// updates the database with the change to the account
			String query = "UPDATE accounts SET " + accountType + " = " + totalFunds + " WHERE username = " + "'"
					+ currUser.getUsername() + "'";

			int result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// catches errors
			e.printStackTrace();
		}
		// returns the funds that was withdrawn
		return funds;
	}

	// checks funds for a user in requested account type
	public double checkFunds(String accountType, BankAccountPojo currUser) {
		// cycles through the account type to check the correct funds
		if (accountType.equals("checking")) {
			return currUser.getChecking();
		} else if (accountType.equals("reserve")) {
			return currUser.getReserve();
		} else if (accountType.equals("savings")) {
			return currUser.getSavings();
		} else {
			// if there is no account it returns -1
			return -1;
		}

	}

}
