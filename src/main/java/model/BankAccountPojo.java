package model;

public class BankAccountPojo {
	private String username;
	private String hash_password;
	private boolean loginSatus;
	private int Id;
	private double checking;
	private double reserve;
	private double savings;
	public BankAccountPojo(String username, String password, int id, double checking, double reserve, double savings){
		this.username = username;
		this.hash_password = password;
		this.loginSatus = false;
		this.Id = id;
		this.checking = checking;
		this.reserve = reserve;
		this.savings = savings;
		
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
		if (this.hash_password.equals(enteredPassword)) {
			return hash_password;
		}
		else {
			return "Incorrect password";
		}
		
	}
	public Boolean checkPass(String enteredPassword) {
		if (this.hash_password.equals(enteredPassword)) {
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
		if (this.hash_password.equals(newPassword)) {
			this.hash_password = newPassword;
			return "Updated password to " + newPassword;
		}
		else {
			return "incorrect password";
		}
	}
	public double getChecking() {
		return this.checking;
	}
	public double getReserve() {
		return this.reserve;
	}
	public double getSavings() {
		return this.savings;
	}
	public double addFunds(double funds, String accountType) {
		
		if(accountType.equals("checking")) {
			this.checking += funds;
			return this.checking;
			
		}else if(accountType.equals("reserve")) {
			this.reserve+= funds;
			return this.reserve;
			
		}else if(accountType.equals("savings")) {
			this.savings+= funds;
			return this.savings;
			
		}else {
			return -0;
		}
	
	}
	public double withdrawalFunds(double funds, String accountType) {
		//TODO errorHandling, cannot go below negative
		if(accountType.equals("checking")) {
			this.checking -= funds;
			return this.checking;
			
		}else if(accountType.equals("reserve")) {
			this.reserve-= funds;
			return this.reserve;
			
		}else if(accountType.equals("savings")) {
			this.savings-= funds;
			return this.savings;
			
		}else {
			return -0;
		}
		
	}
}
