package dao;

import java.util.ArrayList;
import java.util.List;

import model.BankAccountPojo;

public class BankAccountDaoCollectionImpl implements BankAccountDao {
	List<BankAccountPojo> allAccounts = new ArrayList<BankAccountPojo>();
	BankAccountPojo currAccount;
	
	public BankAccountDaoCollectionImpl() {
		BankAccountPojo bankAccount1= new BankAccountPojo("test", "test", 1);
		allAccounts.add(bankAccount1); 
	}
	@Override
	public BankAccountPojo addAccount(BankAccountPojo productPojo) {
		// TODO Auto-generated method stub
		allAccounts.add(productPojo); 
		return null;
	}

	@Override
	public BankAccountPojo updateAccount(BankAccountPojo productPojo) {
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
	public BankAccountPojo getAnAccountById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
	public BankAccountPojo getAnAccountByUsername(String username) {
		// TODO Auto-generated method stub
		BankAccountPojo foundAccount = null;
		for (int i = 0;i < allAccounts.size(); i++) {
			if(allAccounts.get(i).getUsername().equals(username)) {
				foundAccount = allAccounts.get(i);
				break;
			}
		}
		return foundAccount;
		
	}
	public boolean checkAnAccountByUsername(String username) {
		// TODO Auto-generated method stub
		for (int i = 0;i < allAccounts.size(); i++) {
			if(allAccounts.get(i).getUsername().equals(username)) {
				return true;
			}
		}
		return false;
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
	public BankAccountPojo login(BankAccountPojo productPojo) {
		// TODO Auto-generated method stub
		currAccount = productPojo;
		return null;
	}
	


	

}
