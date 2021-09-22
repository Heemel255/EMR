package model;

import java.awt.EventQueue;
import java.util.List;

import emr_gui.LoginFrame;
import model.Design.Appointment;
import model.Helper.MySQLConn;



public class Core
{

	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.getFrame().setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}