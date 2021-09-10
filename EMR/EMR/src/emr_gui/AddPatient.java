package emr_gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Design.Patient;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPatient {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Create the application.
	 */
	public AddPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPatientName = new JLabel("Patient Name:");
		lblPatientName.setBounds(9, 38, 96, 16);
		frame.getContentPane().add(lblPatientName);
		
		textField = new JTextField();
		textField.setBounds(117, 33, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPatientID = new JLabel("PatientID:");
		lblPatientID.setBounds(9, 95, 61, 16);
		frame.getContentPane().add(lblPatientID);
		
		JLabel lblDofB = new JLabel("Date of Birth:");
		lblDofB.setBounds(9, 155, 83, 16);
		frame.getContentPane().add(lblDofB);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(117, 90, 130, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(117, 150, 130, 26);
		frame.getContentPane().add(textField_2);
		
		JLabel br = new JLabel("Branch:");
		br.setBounds(9, 195, 83, 16);
		frame.getContentPane().add(br);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(117, 195, 130, 26);
		frame.getContentPane().add(textField_3);
		
		JButton button = new JButton("Add Patient Record");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient patient = new Patient( textField_1.getText(),  textField.getText(),  textField_2.getText(), textField_3.getText());
				JOptionPane.showMessageDialog(frame.getComponent(0), "A new patient record has been added");
				frame.setVisible(false); 
				frame.dispose(); 
			}
		});
		button.setForeground(Color.BLACK);
		button.setBounds(88, 249, 130, 33);
		frame.getContentPane().add(button);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false); 
				frame.dispose(); 
			}
		});
		
		btnGoBack.setBounds(271, 249, 130, 33);
		frame.getContentPane().add(btnGoBack);
		frame.setVisible(true);
	}

	public void setVisible(boolean b) {
		
	}
}
