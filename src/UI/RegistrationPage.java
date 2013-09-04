package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import User.User;

import Account.Account;

public class RegistrationPage extends JFrame {

	JButton bregister = new JButton("Register");
	JPanel panel = new JPanel();
	JTextField txuser = new JTextField(15);
	JTextField email = new JTextField(40);
	JPasswordField pass = new JPasswordField(15);
	JLabel usLabel = new JLabel("Username: ");
	JLabel pwLabel = new JLabel("Password ");
	JButton bback = new JButton("Back");
	JLabel registerLabel = new JLabel("Register a new account");
	JLabel userLabel = new JLabel("Username ");
	JLabel emailLabel = new JLabel("Email ");
	JLabel passremind = new JLabel("Reminder");
	JTextField pasre = new JTextField(40);

	//
	RegistrationPage(){
	super("Registration");
	setSize(500,400);
	setLocation(500,280);
	panel.setLayout (null); 
	pwLabel.setBounds(0,65,100,20);
	userLabel.setBounds(0,30,100,20);;
	registerLabel.setBounds(70,10,150,20);
	emailLabel.setBounds(0,100,100,20);
	email.setBounds(70,100,150,20);
	txuser.setBounds(70,30,150,20);
	pass.setBounds(70,65,150,20);
	passremind.setBounds(0,140,100,20);
	pasre.setBounds(70,140,100,20);
	bregister.setBounds(70, 160, 100,30);
	bback.setBounds(180,160,100,30);
	
	panel.add(registerLabel);
	panel.add(passremind);
	panel.add(pasre);
	panel.add(txuser);
	panel.add(pass);
	panel.add(email);
	panel.add(bregister);
	panel.add(bback);
	panel.add(pwLabel);
	panel.add(userLabel);
	panel.add(emailLabel);

	getContentPane().add(panel);
	//getContentPane().add(panel2);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	actionRegister();
	actionBack();
	}

	public void actionRegister(){
		bregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String username = txuser.getText();
				String pw = pass.getText();
				String em = email.getText();
				String pasremind = pasre.getText();
				Account account = new Account(username,pw);
				account.setEmail(em);
				account.setReminderWord(pasremind);
				User user = new User(account);
				
				account.validateAccount();
				if(account.accountValidated())
				{
					LoginSystem.table.addAccount(account);
					LoginSystem.manager.setAccountTable(LoginSystem.table);
					if(LoginSystem.manager.checkAccount(account))
					{
						LoginSystem.manager.userLogsIn(user);
						System.out.println("User Logged In: " + user.IsLoggedIn());
						AccountPage accounts = new AccountPage(user);
						accounts.setVisible(true);
						dispose();
						System.out.println("Accounts In Table");
						for(Account a : LoginSystem.table.getAccounts())
						{
							System.out.println("Account: " + a.toString());
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "ERROR INVALID ARGUMENTS");
				}
			}
		});
	}
	
	public void actionBack(){
		bback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				HomePage home = new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
	}
}