package model;

import java.awt.EventQueue;

import emr_gui.LoginFrame;



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