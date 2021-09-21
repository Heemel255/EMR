package unittest;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import model.Design.*;
import model.Helper.EMRDbConn;


public class AppointmentTest {
	
	@Test
	public void AppointmentTestNew() 
	{
		//1:make new appointment by using a random id
		//2:assert it is in DB by checking with the created id 
		//3:remove it from DB
		
		String[][] db = EMRDbConn.retreive("select * from appointment",5);
		Random rand = new Random();
		int randomID = db.length + rand.nextInt(10);
		
		String id = "UnitTestID" + randomID;
		
		Appointment ap = new Appointment(id,"test","test","test","test");
		
		Assert.assertTrue(ap.appointmentIsInDB(id));
		ap.removeAppointment();
	}
	
	@Test
	public void AppointmentTestUpdate() 
	{
		//1:retrieve random id
		//2:make an appointment object from it
		//3:update branch column in DB
		//4:assert if it is updated
		//5:update it again to the original value
		
		String[][] db = EMRDbConn.retreive("select * from appointment",5);
		Random rand = new Random();
		int randomID = rand.nextInt(db.length);
		
		Appointment ap = new Appointment(db[randomID][0]);
		String originalBranchName = db[randomID][4];
		String newBranchName = "UnitTestBranch1";
		
		ap.updateAppointment("Branch", newBranchName);
		
		Assert.assertTrue(ap.appointmentIsUpdatedDB());
		ap.updateAppointment("Branch", originalBranchName);
	}
	
	@Test
	public void AppointmentTestRead() 
	{
		//1:retrieve random id
		//2:check if id exists and is not null by creating appointment object
		String[][] db = EMRDbConn.retreive("select * from appointment",5);
		Random rand = new Random();
		int randomID = rand.nextInt(db.length);
		
		Appointment ap = new Appointment(db[randomID][0]);
		Assert.assertTrue(ap.getAppID() != null);
	}
	
	@Test
	public void AppointmentTestDelete() 
	{
		//1:retrieve random id and create appointment object
		//2:store contents of object temporarily
		//3:delete row with retrieved id
		//4:create an object with previous random id, assert it does not exist
		//5:create row again with stored data
		String[][] db = EMRDbConn.retreive("select * from appointment",5);
		Random rand = new Random();
		int randomID = rand.nextInt(db.length);
		
		Appointment ap = new Appointment(db[randomID][0]);
		String appID = ap.getAppID();
		String appDate = ap.getAppDate();
		String appTime = ap.getAppTime();
		String patientID = ap.getPatientID();
		String branch = ap.getBranch();
		
		ap.removeAppointment();
		
		Appointment ap2 = new Appointment(db[randomID][0]);
		Assert.assertTrue(ap2.getAppID() == null);
		
		Appointment newAp = new Appointment(appID,patientID,appDate,appTime,branch);
	}
}
