package User;
import java.util.*;

import Account.Account;
import Account.AccountTable;

public class LoginManager {
	private User user;
	private ArrayList<User> userList;
	private AccountTable table = new AccountTable();
	
	public LoginManager()
	{
		
	}
	
	public LoginManager(AccountTable t)
	{
		table = t;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public void setAccountTable(AccountTable t)
	{
		table = t;
		setUserList(table);
	}
	
	public void updateAccountTable(AccountTable t)
	{
		table = t;
		setUserList(table);
	}
	
	private void setUserList(AccountTable table)
	{
		ArrayList<Account> accountList = table.getAccounts();
		for(int i=0;i<=accountList.size()-1;i++)
		{
			//userList.add(accountList.get(i).getUser());
		}
	}
	
	public boolean checkAccount(Account tmp)
	{
		return table.checkAccount(tmp);
	}
	
	public void userLogsIn(User u)
	{
		user = u;
		Account a = user.getAccount();
		for(int i=0;i<=table.getAccounts().size()-1;i++)
		{
			Account us = table.getAccount(i);
			if(a.equals(us))
			{
				user.AccountAccessed();
				user.setLoggedIn(true);
				if(user.IsFirstLogin())
				{
					user.setFirstLogin(false);
				}
			}
		}
		
		
		
	}
	
	public void userLogsOut(User u)
	{
		user.setLoggedIn(false);
	}
	
}
