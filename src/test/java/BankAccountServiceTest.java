import static org.junit.Assert.assertEquals;

import org.junit.Test;

import service.BankAccountServiceImpl;

public class BankAccountServiceTest {
	//use mockito
	//mock rules

	@Test
	public void candAddLessThanOrEqualTo0Funds() {
		BankAccountServiceImpl service = new BankAccountServiceImpl();
		assertEquals("funds must be greater than $0", service.addFunds(0, "checking") );
		assertEquals("funds must be greater than $0", service.withdrawalFunds(0, "checking"));
	}
	@Test
	public void invalidAccountType() {
		BankAccountServiceImpl service = new BankAccountServiceImpl();
		assertEquals("Invalid account type.",service.addFunds(100, "checkcehck"));
		assertEquals("Invalid account type.",service.withdrawalFunds(100, "checkcehck"));
	}
}
