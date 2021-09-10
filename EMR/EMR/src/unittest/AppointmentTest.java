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
		//2:assert it is in db by checking with the created id 
		//3:remove it from db
		
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
		//3:update branch column in db
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
}
