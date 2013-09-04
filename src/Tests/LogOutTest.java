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

public class LogOutTest extends TestCase {

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
		manager = new LoginManager();
		table.addAccount(account);
		manager.setAccountTable(table);
		
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	public void testcreateAccount()
	{
		System.out.println("Account: " + account.getEmail());
		System.out.println("Account password: " + account.getPassword());
		System.out.println("Account Username: " + account.getUsername());
		System.out.println("Account Created: " + account.getDateCreated());
	}
	public void testcheckUserInSystem()
	{
		System.out.println("\n\n");
		System.out.println("User username: " + user.getUserUsername());
		System.out.println("User Password: " + user.getUserPassword());
		System.out.println("User email: " + user.getAccount().getEmail());
		System.out.println("User account" + user.getAccount().toString() + " is the same as the account, " + account.toString());
		assertTrue(manager.checkAccount(account));
	}
	
	public void testUserLogsOut()
	{
		System.out.println("Users First Login: " + user.IsFirstLogin());
		System.out.println("User is Logged In: " + user.IsLoggedIn());
		System.out.println("User Logging In");
		manager.userLogsIn(user);
		System.out.println("User is Logged In: " + user.IsLoggedIn());
		manager.userLogsOut(user);
		System.out.println("User Logging Out");
		System.out.println("User is Logged In: " + user.IsLoggedIn());
		manager.userLogsIn(user);
		System.out.println("User Loggin In Again");
		System.out.println("Users First Login: "+ user.IsFirstLogin());
	}
	
	@Test
	public static TestSuite suite() {
		return new TestSuite(LogOutTest.class);
	}

}
