package UI;
import javax.swing.*;

import javax.swing.*;

import User.User;

import Account.Account;
import Account.AccountTable;

import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame {

public static void main(String[] args) {
	AccountTable table = new AccountTable();
	Account firstAccount = new Account("Test", "1234");
	table.addAccount(firstAccount);
LoginPage frameTabel = new LoginPage();
}

JButton blogin = new JButton("Login");
JButton bforgot = new JButton("Forgot Password?");
JButton bregister = new JButton("Register");
JPanel panel = new JPanel();
JPanel panel2 = new JPanel();
JTextField txuser = new JTextField(15);
JPasswordField pass = new JPasswordField(15);
JLabel usLabel = new JLabel("Username: ");
JLabel pwLabel = new JLabel("Password: ");
JButton bback = new JButton("Back");

//
LoginPage(){
super("Login Autentification");
setSize(300,200);
setLocation(500,280);
panel.setLayout (null); 

usLabel.setBounds(0,30,80,20);
txuser.setBounds(100,30,150,20);
pwLabel.setBounds(0,65,80,20);
pass.setBounds(100,65,150,20);
blogin.setBounds(110,100,80,20);
bregister.setBounds(70, 70, 50, 50);
bforgot.setBounds(20,100,80,20);
bback.setBounds(200,100,80,20);

panel.add(blogin);
panel.add(txuser);
panel.add(pass);
panel.add(bforgot);
panel2.add(bregister);
panel.add(bback);
panel.add(usLabel);
panel.add(pwLabel);

getContentPane().add(panel);
//getContentPane().add(panel2);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
actionlogin();
actionBack();
actionReminder();
}

public void actionlogin(){
	blogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			String puname = txuser.getText();
			String ppaswd = pass.getText();
			Account temp = new Account(puname,ppaswd);
			User user = new User(temp);
			if(LoginSystem.table.getAccounts().size() ==0)
			{
				JOptionPane.showMessageDialog(null, "No Accounts In The System, Please Register To Login");
			}
			
			for(int i=0;i<=LoginSystem.table.getAccounts().size()-1;i++)
			{
				Account tmp = LoginSystem.table.getAccount(i);
				
				
				if(temp.getUsername().matches(tmp.getUsername()) && temp.getPassword().matches(tmp.getPassword())) {
					user = new User(tmp);
					AccountPage regFace = new AccountPage(user);
					regFace.setVisible(true);
					dispose();
					break;
				} 
				
					JOptionPane.showMessageDialog(null,"Wrong Password / Username");
					txuser.setText("");
					pass.setText("");
					txuser.requestFocus();
				
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

public void actionReminder()
{
	bforgot.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			ReminderWordPage rem = new ReminderWordPage();
			rem.setVisible(true);
			dispose();
		}
	});
}
}

