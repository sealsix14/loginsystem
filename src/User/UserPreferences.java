package User;

public class UserPreferences {
	
	public UserPreferences()
	{
		time = TimeZone.Eastern;
		prefered = PreferedContact.Email;
		contactYouDeals = true;
	}
	
	public enum PreferedContact
	{
		Email, Phone, Both
	}
	private boolean contactYouDeals;
	public enum TimeZone
	{
		Eastern, Central, Mountain, Western,
	}
	public TimeZone time;
	private String preferredName;
	public PreferedContact prefered;
	
	public void setPreferredContact(PreferedContact c)
	{
		prefered = c;
	}
	
	public String getPreferredContact()
	{
		return prefered.toString();
	}
	
	public void setTimeZone(TimeZone t)
	{
		time = t;
	}
	
	public String getTimeZone()
	{
		return time.toString();
	}
	
	
	
	public void setContactStatus(boolean status)
	{
		contactYouDeals = status;
	}
	
	public boolean canContact()
	{
		return contactYouDeals;
	}
	
	public void setPreferredName(String pname)
	{
		preferredName = pname;
	}
	
	public String getPreferredName()
	{
		return preferredName;
	}
	
}
