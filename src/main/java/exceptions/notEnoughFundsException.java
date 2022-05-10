package exceptions;

public class notEnoughFundsException {
	static public String Message(String accountType) {
		return "Not enough funds to withdrawal from " + accountType;
	}
		
}
