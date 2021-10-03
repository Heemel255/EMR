package emr_gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Design.MedicalRecord;
import model.Design.Patient;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyRecord {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnBack;
	private JComboBox changeBox;
	String[] changeValue = {"AssessDate","Diagnosis","Prescription"};

	/**
	 * Create the application.
	 */
	public ModifyRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Change:");
		label.setBounds(25, 29, 96, 16);
		frame.getContentPane().add(label);
		
		
		
		changeBox = new JComboBox(changeValue);
		changeBox.setSelectedItem(1);
		changeBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		changeBox.setBounds(135, 29, 156, 16);
		frame.getContentPane().add(changeBox);
		
		
		JLabel label_1 = new JLabel("Value:");
		label_1.setBounds(25, 81, 61, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("RecordID:");
		label_2.setBounds(25, 129, 83, 16);
		frame.getContentPane().add(label_2);
		
	
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(139, 76, 130, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(139, 124, 130, 26);
		frame.getContentPane().add(textField_2);
		
		JButton button = new JButton("Modify Patient Record");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicalRecord medicalRecord = new MedicalRecord(textField_2.getText());
				medicalRecord.updateRecord((String) changeBox.getSelectedItem(), textField_1.getText());
				JOptionPane.showMessageDialog(frame.getComponent(0), "The patient record was modified.");
			}
		});
		button.setForeground(Color.BLACK);
		button.setBounds(84, 187, 148, 38);
		frame.getContentPane().add(button);
		
		btnBack = new JButton("Go Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false); 
				frame.dispose(); 
			}
		});
		btnBack.setBounds(277, 187, 117, 38);
		frame.getContentPane().add(btnBack);
		frame.setVisible(true);
	}

	public void setVisible(boolean b) {
		
		
	}

}
