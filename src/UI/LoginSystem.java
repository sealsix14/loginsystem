package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import User.LoginManager;

import Account.AccountTable;

public class LoginSystem {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static AccountTable table = new AccountTable();
	public static LoginManager manager = new LoginManager();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSystem window = new LoginSystem();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginSystem() {
		initialize();
		HomePage home = new HomePage();
		home.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
