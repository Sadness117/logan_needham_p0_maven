
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Test;

import dao.BankAccountDaoDatabaseImpl;
import exceptions.notEnoughFundsException;
import model.BankAccountPojo;
import service.BankAccountServiceImpl;

public class BankAccountServiceTest {
	//creates service object
	BankAccountServiceImpl service = new BankAccountServiceImpl();
	//creates mock dao object
	BankAccountDaoDatabaseImpl dao = mock(BankAccountDaoDatabaseImpl.class);
	//user for testing
	BankAccountPojo testUser = new BankAccountPojo("testUsername", "testPass", 1, 200, 10000, 40000);
	@Test
	public void candAddLessThanOrEqualTo0AddFunds() {
		//exception handle for adding funds
		assertEquals("funds must be greater than $0", service.addFunds(0, "checking", testUser) );
	}
	@Test
	public void canAddLessThanOrEqualToWithdrawalFunds() {
		//Exception for withdrawaling 0 funds
		assertEquals("funds must be greater than $0", service.withdrawalFunds(0, "checking", testUser));
	}
	@Test
	public void invalidAccountTypeAddFunds() {
		//exception for typos
		assertEquals("Invalid account type.",service.addFunds(100, "checkcehck", testUser));
	}
	@Test
	public void invalidAccountTypeWithdrawalFunds() {
		//exception for typos
		assertEquals("Invalid account type.",service.withdrawalFunds(100, "checkcehck", testUser));
	}
	@Test
	public void incorrectUsernameOrPassword() {
		//invalid username or password check
		when(dao.login("sakjsdl","askdhaksd")).thenReturn(null);
		assertEquals(null,service.login("sakjsdl","askdhaksd"));
	}
	@Test
	public void invalidAccountTypeCheckFunds() {
		//invalid account typo
		assertEquals("Invalid account type.",service.checkFunds("checkcehck", testUser));
	}
	@Test
	public void nothingToLogoutOfLogout() {
		//cant logout of an account that is not logged in
		assertEquals("Nothing to logout of.",service.logout("y",null));
	}
	@Test
	public void addFunds() {
		//adds $100 to checking
		when(dao.addFunds(100, "checking", testUser)).thenReturn((double) (100));
		assertEquals("$100.00 added to checking", service.addFunds(100, "checking", testUser));
	}
	@Test
	public void withdrawalFunds() throws notEnoughFundsException {
		//withdrawals $100 from checking
		when(dao.withdrawalFunds(100, "checking", testUser)).thenReturn((double) 100);
		assertEquals("$100.00 withdrawn from checking", service.withdrawalFunds(100, "checking", testUser));
	}
	@Test
	public void addAccount() throws SQLException {
		//creates an account called newTestUsername
		when(dao.addAccount("newTestUsername","testPassword")).thenReturn(true);
		assertEquals("newTestUsername successfully added.", service.addAccount("newTestUsername","testPassword"));
	}
	@Test
	public void login(){
		//logs in the test user with testUsername
		when(dao.login("testUsername", "testPass")).thenReturn(testUser);
		assertEquals(testUser, service.login("testUsername","testPass"));
	}
	@Test
	public void checkFunds(){
		//checks funds for checking and returns $200
		when(dao.checkFunds("checking", testUser)).thenReturn((double) 200);
		assertEquals("$200.00 in checking", service.checkFunds("checking", testUser));
	}
	@Test
	public void logout(){
		//logs a user out
		assertEquals("Sucessfully logged out", service.logout("y", testUser));
	}
	@Test
	public void transferFunds(){
		//transfers $200 from checking to savings
		when(dao.transferFunds("checking", 200, "savings", testUser)).thenReturn((double) 200);
		assertEquals("$200.00 transfered.", service.transferFunds("checking", 200, "savings", testUser));
	}
}
