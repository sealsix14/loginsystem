package UI;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Account.Account;

public class HomePage extends JFrame {

public static void main(String[] args) {
HomePage frameTabel = new HomePage();
}

JLabel welcome = new JLabel("Welcome to the Login System v1.0");
JPanel panel = new JPanel();
JButton bregister = new JButton("Register Now");
JButton blogin = new JButton("Login");

HomePage(){
super("Welcome to the Login System");
setSize(500,300);
setLocation(500,280);
panel.setLayout (null);
welcome.setBounds(140,0,200,100);
bregister.setBounds(60, 200, 200, 30);
blogin.setBounds(345, 200, 100, 30);
panel.add(welcome);
panel.add(bregister);
panel.add(blogin);

getContentPane().add(panel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
actionRegister();
actionLogin();
}

public void actionRegister(){
	bregister.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			//LoginPage login = new LoginPage();
			//login.setVisible(true);
			RegistrationPage reg = new RegistrationPage();
			reg.setVisible(true);
			dispose();

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