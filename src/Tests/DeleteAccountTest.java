package Tests;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Account.Account;
import Account.AccountTable;
import User.LoginManager;
import User.User;
import User.UserPreferences;

public class DeleteAccountTest extends TestCase {
	Account account;
	AccountTable table;
	User user;
	LoginManager manager;
	
	@Before
	public void setUp() throws Exception 
	{
		account = new Account("Brandon", "bj01415");
		account.setEmail("bj01415@georgiasouthern.edu");
		table = new AccountTable();
		user = new User(account);
		UserPreferences up = new UserPreferences();
		
		user.getPreferences().setContactStatus(false);
		user.getPreferences().setPreferredName("BDawg");
		manager = new LoginManager();
		table.addAccount(account);
		manager.setAccountTable(table);
		
	}
	@After
	public void tearDown() throws Exception {
	}

	public void testRegistration()
	{
		System.out.println("User Registered as:");
		System.out.println("Username: " + account.getUsername());
		System.out.println("Password: " + account.getPassword());
		System.out.println("Email: " + account.getEmail());
		System.out.println("Date Created: " + account.getDateCreated());
		System.out.println("User Preference for contact: " + user.getPreferences().canContact());
		System.out.println("User Preference for name: " + user.getPreferences().getPreferredName());
	}
	
	public void testDeletion()
	{
		System.out.println("Accounts in table: " + table.getAccounts().size());
		table.removeAccount(account);
		System.out.println("Accounts in table after deletion: " + table.getAccounts().size());
	}
	@Test
	public static TestSuite suite() {
		return new TestSuite(DeleteAccountTest.class);
	}

}
