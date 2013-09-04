package User;
import java.util.ArrayList;
import Account.*;
import java.util.Calendar;
public class User {
	
	private String username;
	private String userPassword;
	private String lastDateAccessed;
	private String email;
	private String dateCreated;
	private boolean firstLogin = true;
	private boolean isLoggedIn = false;
	private ArrayList<Integer> loginIDs;
	UserPreferences preferences;
	Account account;
	StringBuilder sb = new StringBuilder();
	
	public User(Account account)
	{
		preferences = new UserPreferences();
		username = account.getUsername();
		userPassword = account.getPassword();
		email = account.getEmail();
		this.account = account;
		buildDateString();
		setInformation();
	}
	
	public User()
	{
		preferences = new UserPreferences();
	}
	
	public void setAccount(Account ac)
	{
		account = ac;
		username = account.getUsername();
		userPassword = account.getPassword();
		buildDateString();
		setInformation();
	}
	
	public void buildDateString()
	{
		sb.append(Calendar.MONTH);sb.append("/");
		sb.append(Calendar.DAY_OF_MONTH);sb.append("/");
		sb.append(Calendar.YEAR);
	}
	private void setInformation()
	{
		username = account.getUsername();
		preferences.setPreferredName(username);
		userPassword = account.getPassword();
		loginIDs = new ArrayList<Integer>();
		dateCreated = sb.toString();
	}
	
	public String getDateCreated()
	{
		return dateCreated;
	}
	
	public boolean IsLoggedIn()
	{
		return isLoggedIn;
	}
	
	public void setLoggedIn(boolean log)
	{
		isLoggedIn = log;
	}
	
	public String getUserPassword()
	{
		return userPassword;
	}
	
	public String getUserUsername()
	{
		return username;
	}
	
	public void AccountAccessed()
	{
		lastDateAccessed = sb.toString();
	}
	
	public String getDateLastAccessed()
	{
		return lastDateAccessed;
	}
	
	public UserPreferences getPreferences()
	{
		return preferences;
	}
	
	public Account getAccount()
	{
		return account;
	}
	
	public boolean IsFirstLogin()
	{
		return firstLogin;
	}
	
	public void setFirstLogin(boolean log)
	{
		firstLogin = false;
	}

	public void setName(String userName2) {
		username = userName2;
	}
	
	public void setPassword(String pw)
	{
		userPassword = pw;
	}
}
