package unittest;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.Design.Patient;
import model.Helper.EMRDbConn;

public class PatientTest {
	
	@Test
	public void PatientTestNew() 
	{
		//1:make new patient by using a random id
		//2:assert it is in db by checking with the created id 
		//3:remove it from db
		
		String[][] db = EMRDbConn.retreive("select * from patient",4);
		Random rand = new Random();
		int randomID = db.length + rand.nextInt(10);
		
		String id = "UnitTestID" + randomID;
		
		Patient p = new Patient(id,"test","test","test");
		
		Assert.assertTrue(p.patientIsInDB(id));
		p.removePatient();
	}
	
	@Test
	public void PatientTestUpdate() 
	{
		//1:retrieve random id
		//2:make an patient object from it
		//3:update DofB column in db
		//4:assert if it is updated
		//5:update it again to the original value
		
		String[][] db = EMRDbConn.retreive("select * from patient",4);
		Random rand = new Random();
		int randomID = rand.nextInt(db.length);
		
		Patient p = new Patient(db[randomID][0]);
		String originalDofB = db[randomID][2];
		String newDofB = "UnitTestDofB4f8gg8";
		
		p.updatePatient("DoB", newDofB);
		
		Assert.assertTrue(p.patientIsUpdatedDB());
		p.updatePatient("DoB", originalDofB);
	}
}
