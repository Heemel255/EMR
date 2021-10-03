package core;

import java.awt.EventQueue;
import java.util.List;

import emr_gui.LoginFrame;
import model.Design.Appointment;
import model.Helper.MySQLConn;



public class Application
{
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginFrame().getFrame().setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}