package emr_gui;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Design.MedicalRecord;
import model.Design.Patient;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SearchPatient {

	private JFrame frame;
	private JTextField textField;
	private JButton btnGoBack;
	private JButton btnSearch;

	
	/**
	 * Create the application.
	 */
	public SearchPatient() {
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
		
		JLabel lblSearchPatientName = new JLabel("PatientID:");
		lblSearchPatientName.setBounds(23, 53, 139, 16);
		frame.getContentPane().add(lblSearchPatientName);
		
		textField = new JTextField();
		textField.setBounds(168, 48, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.setVisible(false); 
				frame.dispose(); 
			}
		});
		btnGoBack.setBounds(234, 166, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> a = new ArrayList<String>();
				MedicalRecord.allRecords(a,textField.getText());
				
				for(String s : a) {
					JOptionPane.showMessageDialog(frame.getComponent(0), s);


				}
				

		}});
		btnSearch.setBounds(45, 166, 117, 29);
		frame.getContentPane().add(btnSearch);
		frame.setVisible(true);
	}

	public void setVisible(boolean b) {
		
		
	}

}
