package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import User.User;
import Account.Account;

public class ReminderWordPage extends JFrame {

public static void main(String[] args) {
}

JLabel welcome = new JLabel("Forgot Your Password? Enter your Email below");
JPanel panel = new JPanel();
JButton bgetPw = new JButton("Get Password");
JButton blogin = new JButton("Login");
JLabel passremind = new JLabel("");
JTextField remindEmail = new JTextField(40);
JLabel remindEm = new JLabel("Account Email");

ReminderWordPage(){
super("Reminder Word");
setSize(500,300);
setLocation(500,280);
panel.setLayout (null);
welcome.setBounds(140,0,400,100);
remindEm.setBounds(100,70,100,20);
remindEmail.setBounds(210,70,100,30);
bgetPw.setBounds(40, 200, 150, 30);
blogin.setBounds(345, 200, 100, 30);
passremind.setBounds(100,100,200,30);
panel.add(passremind);
panel.add(welcome);
panel.add(bgetPw);
panel.add(blogin);
panel.add(remindEm);
panel.add(remindEmail);

getContentPane().add(panel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
actiongetPw();
actionLogin();
}

public void actiongetPw(){
	bgetPw.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			//LoginPage login = new LoginPage();
			//login.setVisible(true);
			Account ac = LoginSystem.table.getAccount(remindEmail.getText());
			if(ac != null)
			{
			passremind.setText(ac.getreminderWord());
			
			}
			else
			{
			JOptionPane.showMessageDialog(null, "Email is not in system, please try again.");
			}
}
});
}

public void actionLogin()
{
	blogin.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
			LoginPage login = new LoginPage();
			login.setVisible(true);
			dispose();
		}
	});
}
}