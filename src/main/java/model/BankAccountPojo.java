package model;

public class BankAccountPojo {
	private String username;
	private String password;
	private boolean loginSatus;
	private int Id;
	private int checking;
	private int reserve;
	private int savings;
	public BankAccountPojo(String username, String password, int Id){
		this.username = username;
		this.password = password;
		this.loginSatus = false;
		this.Id = Id;
		this.checking = 0;
		this.reserve = 0;
		this.savings = 0;
		
	}
	public String getCheckingInfo() {
		return "$" + this.checking + " in checking account.";
	}
	public String getReserveInfo() {
		return "$" + this.reserve + " in reserve account.";
	}
	public String getSavingsInfo() {
		return "$" + this.savings + " in savings account.";
	}
	public String getPassword(String enteredPassword) {
		if (this.password.equals(enteredPassword)) {
			return password;
		}
		else {
			return "Incorrect password";
		}
		
	}
	public Boolean checkPass(String enteredPassword) {
		if (this.password.equals(enteredPassword)) {
			return true;
		}else {
			return false;
		}
	}
	public String getUsername() {
		return this.username;
	}
	public boolean checkLoggedIn() {
		if (this.loginSatus == true) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getId() {
		return this.Id;
	}
	public String changeUsername(String currUsername, String newUsername) {
		if (this.username.equals(currUsername)) {
			this.username = newUsername;
			return "Updated username to " + newUsername;
		}
		else {
			return "incorrect Username";
		}
	}
	public String changePassword(String currPassword, String newPassword) {
		if (this.password.equals(newPassword)) {
			this.password = newPassword;
			return "Updated password to " + newPassword;
		}
		else {
			return "incorrect password";
		}
	}
	public int getChecking() {
		return this.savings;
	}
	public int getReserve() {
		return this.reserve;
	}
	public int getSavings() {
		return this.savings;
	}
	public String addFunds(int funds, String accountType) {
		String message;
		if(accountType.equals("checking")) {
			this.checking += funds;
			message = "funds added to checking";
		}else if(accountType.equals("reserve")) {
			this.reserve+= funds;
			message = "funds added to reserve";
		}else if(accountType.equals("savings")) {
			this.savings+= funds;
			message = "funds added to savings";
		}else {
			message = "invalid account type";
		}
		return message;
	}
	public String withdrawalFunds(int funds, String accountType) {
		//TODO errorHandling, cannot go below negative
		String message = null;
		if(accountType.equals("checking")) {
			if(this.checking -funds < 0) {
			this.checking -= funds;
		}else if(accountType.equals("reserve")) {
			this.reserve-= funds;
			message = "funds removed from reserve";
		}else if(accountType.equals("savings")) {
			this.savings-= funds;
			message = "funds removed from savings";
		}else {
			message = "invalid account type";
		}
		
		}
		return message;
	}
}
