package exceptions;

public class notEnoughFundsException extends Exception{
	static public String Message(String accountType) {
		return "Not enough funds to withdrawal from " + accountType;
	}
		
}
