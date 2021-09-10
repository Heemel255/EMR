package emr_gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Design.MedicalRecord;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewRecord {

	private JFrame frame;
	private JTextField id;
	private JTextField patientid;


	/**
	 * Create the application.
	 */
	public NewRecord() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPrescriptionid = new JLabel("ID:");
		lblPrescriptionid.setBounds(46, 43, 98, 16);
		frame.getContentPane().add(lblPrescriptionid);
		
		id = new JTextField();
		id.setBounds(166, 38, 130, 26);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		JLabel lblPrescriptionDate = new JLabel("PatientID:");
		lblPrescriptionDate.setBounds(22, 96, 112, 24);
		frame.getContentPane().add(lblPrescriptionDate);
		
		patientid = new JTextField();
		patientid.setBounds(166, 95, 130, 26);
		frame.getContentPane().add(patientid);
		patientid.setColumns(10);
		
		JLabel lbldocid = new JLabel("DoctorID:");
		lbldocid.setBounds(22, 156, 112, 24);
		frame.getContentPane().add(lbldocid);
		
		JTextField docid = new JTextField();
		docid.setBounds(166, 155, 130, 26);
		frame.getContentPane().add(docid);
		docid.setColumns(10);
		
		JLabel lbldate = new JLabel("AssessDate:");
		lbldate.setBounds(22, 156+60, 112, 24);
		frame.getContentPane().add(lbldate);
		
		JTextField assesdate = new JTextField();
		assesdate.setBounds(166, 155+60, 130, 26);
		frame.getContentPane().add(assesdate);
		assesdate.setColumns(10);
		
		JLabel lbldiag = new JLabel("Diagnosis:");
		lbldiag.setBounds(22, 156+120, 112, 24);
		frame.getContentPane().add(lbldiag);
		
		JTextField diag = new JTextField();
		diag.setBounds(166, 155+120, 130, 26);
		frame.getContentPane().add(diag);
		diag.setColumns(10);
		
		JLabel prescripdiag = new JLabel("Prescription:");
		prescripdiag.setBounds(22, 156+180, 112, 24);
		frame.getContentPane().add(prescripdiag);
		
		JTextField prescrip = new JTextField();
		prescrip.setBounds(166, 155+180, 130, 26);
		frame.getContentPane().add(prescrip);
		prescrip.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				MedicalRecord medicalRecord = new MedicalRecord(id.getText(),patientid.getText(),docid.getText(),assesdate.getText(),diag.getText(),prescrip.getText());
				JOptionPane.showMessageDialog(frame.getComponent(0), "New record has been added.");
			}
		});
		btnConfirm.setBounds(44, 398, 117, 29);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.setVisible(false); 
				frame.dispose(); 
			}
		});
		btnGoBack.setBounds(226, 398, 117, 29);
		frame.getContentPane().add(btnGoBack);
		frame.setVisible(true);
	}

	public void setVisible(boolean b) {
	
		
	}

}
