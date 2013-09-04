package UI;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import User.User;
import User.UserPreferences;
import User.UserPreferences.PreferedContact;
import User.UserPreferences.TimeZone;

public class Preferencespage extends JFrame {
	User user;
	UserPreferences pref;
	
	JPanel panel = new JPanel();
	JLabel timeZone = new JLabel();
	JLabel date = new JLabel();
	JLabel contact = new JLabel();
	JLabel profile = new JLabel("User Profile");
	JButton blogout = new JButton("Log Out");
	JButton bback = new JButton("Dont Editing");
	JButton bpref = new JButton("Edit Preferences");
	JComboBox prefOpt = new JComboBox();
	JComboBox prefTime = new JComboBox();
	ButtonGroup group = new ButtonGroup();
	JCheckBox timeEast = new JCheckBox("Eastern");
	JCheckBox timeCen = new JCheckBox("Central");
	JCheckBox timeMoun = new JCheckBox("Mountain");
	JCheckBox timeWest = new JCheckBox("Western");
	
	JCheckBox phone = new JCheckBox("Phone");
	JCheckBox email = new JCheckBox("Email");
	JLabel prefcon = new JLabel("Contact Preferences");
//	group.add(timeEast);
//	group.add(timeCen);
//	gruop.add(timeMoun);
//	group.add(timeWest);
	Checkbox contactEm = new Checkbox("Email");
	Checkbox contactPh = new Checkbox("Phone");
	public Preferencespage(User user){
	super("Your Account");
	this.user = user;
	pref = this.user.getPreferences();
	setSize(500,300);
	setLocation(500,280);
	panel.setLayout (null);
	timeZone.setText("Time Zone");
	date.setText(user.getAccount().getDateCreated());
	timeZone.setBounds(30,30,100,30);
	date.setBounds(30, 65, 100, 30);
	prefcon.setBounds(30,100,100,30);
	phone.setBounds(30,140,50,20);
	email.setBounds(80,140,50,20);
	bback.setBounds(200, 200, 150, 30);
	timeEast.setBounds(30,65,100,30);
	timeCen.setBounds(130,65,100,30);
	timeMoun.setBounds(230,65,100,30);
	timeWest.setBounds(330,65,100,30);
	panel.add(timeZone);
	panel.add(prefcon);
	panel.add(email);
	panel.add(phone);
	panel.add(date);
	panel.add(bback);
	panel.add(timeEast);
	panel.add(timeCen);
	panel.add(timeMoun);
	panel.add(timeWest);
	getContentPane().add(panel);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	actionBack(user);
	updateTime(user);
	
	}

	public void updateContact(final User u)
	{
		if(phone.isSelected() && email.isSelected())
		{
			u.getPreferences().setPreferredContact(UserPreferences.PreferedContact.Both);
			
		}
		if(email.isSelected())
		{
			u.getPreferences().setPreferredContact(UserPreferences.PreferedContact.Email);	
		}
		if(phone.isSelected())
		{
			u.getPreferences().setPreferredContact(UserPreferences.PreferedContact.Phone);
		}
		
	}
	
	public void updateTime(final User u)
	{
		if(timeEast.isSelected())
		{
			timeWest.disable();
			timeCen.disable();
			timeMoun.disable();
			u.getPreferences().setTimeZone(u.getPreferences().time.Eastern);
		}
		if(timeWest.isSelected())
		{
			timeEast.disable();
			timeCen.disable();
			timeMoun.disable();
			u.getPreferences().setTimeZone(u.getPreferences().time.Western);
		}
		if(timeCen.isSelected())
		{
			timeEast.disable();
			timeWest.disable();
			timeMoun.disable();
			u.getPreferences().setTimeZone(u.getPreferences().time.Central);
		}
		if(timeMoun.isSelected())
		{
			timeEast.disable();
			timeCen.disable();
			timeWest.disable();
			u.getPreferences().setTimeZone(u.getPreferences().time.Mountain);
		}
	}
	
	public void actionBack(final User u)
	{
		bback.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				updateTime(u);
				updateContact(u);
				dispose();
				AccountPage account = new AccountPage(u);
				account.setVisible(true);
			}
		});
	}
	}

