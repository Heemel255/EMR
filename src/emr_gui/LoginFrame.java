package emr_gui;


import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.NEW;

import model.Design.Doctor;
import model.Design.Nurse;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class LoginFrame {

	private JFrame frame;
	private JPasswordField passwordField_1;


	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
	}
	
	public JFrame getFrame()
	{
		return this.frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Log in");
		
		
		
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(153, 120, 130, 26);
		frame.getContentPane().add(passwordField_1);
		
	
		
		JLabel lblNewLabel_1 = new JLabel("LoginID");
		lblNewLabel_1.setBounds(80, 125, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean inco = true;
				ArrayList<String> a = new ArrayList<String>();
				Nurse.allUserID(a);
				Doctor.allUserID(a);
				for(String s : a) {
					if(s.equals(new String(passwordField_1.getPassword()))) {
						new Welcome().setVisible(true);
						inco = false;
						frame.setVisible(false); 
						frame.dispose(); 
					}
					
				}
				if(inco)
					JOptionPane.showMessageDialog(frame.getComponent(0), "Incorrect UserID");

				
			}
		});
		btnNewButton.setBounds(153, 172, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Login Page");
		lblNewLabel_2.setBounds(180, 24, 70, 16);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setVisible(true);
		
		
	
		

	}
}
