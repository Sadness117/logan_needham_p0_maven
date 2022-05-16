package exceptions;

public class notEnoughFundsException extends Exception{
	//error for not having enough funds
	static public String Message(String accountType) {
		return "Not enough funds to withdrawal from " + accountType;
	}
		
}
