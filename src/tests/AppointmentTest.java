package tests;

import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import model.Design.*;
import model.Helper.MySQLConn;

public class AppointmentTest {
	
	@Test
	public void AppointmentTestNew() 
	{
		//1:make new appointment by using a random id
		//2:assert it is in DB by checking with the created id 
		//3:remove it from DB
		
		Random rand = new Random();
		int randomID = rand.nextInt(1000);
		
		String id = "TestID" + randomID;
		
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
		
		List<String> li = MySQLConn.Retrieve("select * from appointment", "AppID");
		
		Random rand = new Random();
		int randomID = rand.nextInt(li.size());
		
		Appointment ap = new Appointment(li.get(randomID));
		String originalBranchName = ap.getBranch();
		String newBranchName = "TestBranch1";
		
		ap.updateAppointment("Branch", newBranchName);
		
		Assert.assertTrue(ap.appointmentIsUpdatedDB());
		ap.updateAppointment("Branch", originalBranchName);
	}
	
	@Test
	public void AppointmentTestRead() 
	{
		//1:retrieve random id
		//2:check if id exists and is not null by creating appointment object
		List<String> li = MySQLConn.Retrieve("select * from appointment", "AppID");
		Random rand = new Random();
		int randomID = rand.nextInt(li.size());
		
		Appointment ap = new Appointment(li.get(randomID));
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
		List<String> li = MySQLConn.Retrieve("select * from appointment", "AppID");
		
		Random rand = new Random();
		int randomID = rand.nextInt(li.size());
		
		Appointment ap = new Appointment(li.get(randomID));
		String appID = ap.getAppID();
		String appDate = ap.getAppDate();
		String appTime = ap.getAppTime();
		String patientID = ap.getPatientID();
		String branch = ap.getBranch();
		
		ap.removeAppointment();
		
		Appointment ap2 = new Appointment(li.get(randomID));
		Assert.assertTrue(ap2.getAppID() == null);
		
		Appointment newAp = new Appointment(appID,patientID,appDate,appTime,branch);
	}
}
