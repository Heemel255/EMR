package emr_gui;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Design.Ward;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WardSummary {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;



	/**
	 * Create the application.
	 */
	public WardSummary() {
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
		
		JLabel lblWardid = new JLabel("WardID:");
		lblWardid.setBounds(40, 38, 61, 16);
		frame.getContentPane().add(lblWardid);
		
		
		
		textField = new JTextField();
		textField.setBounds(141, 33, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnProduceSummary = new JButton("Produce Summary");
		btnProduceSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ward ward = new Ward(textField.getText());
				JOptionPane.showMessageDialog(frame.getComponent(0), "Capacity: " + ward.getCapacity() + "\nTaken:" + ward.getCapTaken());
			}
		});
		btnProduceSummary.setBounds(40, 215, 151, 29);
		frame.getContentPane().add(btnProduceSummary);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.setVisible(false); 
				frame.dispose(); 
			}
		});
		btnGoBack.setBounds(244, 215, 117, 29);
		frame.getContentPane().add(btnGoBack);
		frame.setVisible(true);
		
		
	}

	public void setVisible(boolean b) {

		
	}

}
