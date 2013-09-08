package Account;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import User.User;

public class Account {

	//WE CREATE A USER WHEN AN ACCOUNT IS CREATED;
	//private User accountUser;
	
	private int userID;
	private String password;
	private String reminderWord;
	private String emailAddress;
	private String userName;
	private boolean accountValidated;
	private String dateCreated;
	private StringBuilder sb = new StringBuilder();

	private Pattern pattern;
	private Matcher matcher;

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
	public Account(String user, String pw)
	{
		//accountUser = new User();
		userName = user;
		password = pw;
		accountValidated = false;
		//accountUser.setName(userName);
		//accountUser.setPassword(password);
		buildDateString();
		dateCreated = sb.toString();

	}
	//Static int for counting bad passwords
	private static int badPasswords=0;
	
	public void buildDateString()
	{
		Calendar rightNow = Calendar.getInstance(TimeZone.getDefault());
		sb.append(Calendar.MONTH);sb.append("/");
		sb.append(Calendar.DAY_OF_MONTH);sb.append("/");
		sb.append(Calendar.YEAR);
	}
	
	public String getDateCreated()
	{
		return dateCreated;
	}
	
//	public User getUser()
//	{
//		//accountUser.setAccount(this);
//		//return accountUser;
//	}
	
	public int countBadPasswords()
	{
		return badPasswords;
	}
	
	public void setName(String name)
	{
		userName = name;
	}
	
	public void setEmail(String email)
	{
		emailAddress = email;
	}
	
	public void setPassword(String pw)
	{
		password = pw;
	}
	
	public String getEmail()
	{
		String temp = emailAddress;
		return temp;
	}
	
	public int getUserID()
	{
		int temp = userID;
		return temp;
	}
	
	public String getreminderWord()
	{
		String temp = reminderWord;
		return temp;
	}
	
	public void setReminderWord(String rm)
	{
		reminderWord = rm;
	}
	
	public String getPassword()
	{
		String temp = password;
		return temp;
	}
	
	public String getUsername()
	{
		String temp = userName;
		return temp;
	}
	
	//Private Methods for validating an account for registration
	//-------------------------------------------
	 private boolean validatePassword(final String password)
	 {
		 System.out.println(password);
		  pattern = Pattern.compile(PASSWORD_PATTERN);
		  matcher = pattern.matcher(password);
		  return matcher.matches();

	  }
	 
	 private boolean validateEmail(final String email)
	 {
		 System.out.println(email);
		 pattern = Pattern.compile(EMAIL_PATTERN);
		 matcher = pattern.matcher(email);
		 return matcher.matches();
	 }
	//-------------------------------------------
	public void validateAccount()
	{
		if(validatePassword(password) && validateEmail(emailAddress))
		{
			accountValidated = true;
		}
		else
		{
			System.out.println("Email or Password have not met requirements");
		}
	}
	
	public boolean userIsValidated(String uname, String pw)
	{
		return uname.matches(userName) && pw.matches(password);
	}
	
	public boolean accountValidated()
	{
		return accountValidated;
	}
}
