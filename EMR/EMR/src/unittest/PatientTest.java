package unittest;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.Design.Appointment;
import model.Design.Patient;
import model.Helper.EMRDbConn;

public class PatientTest {
	
	@Test
	public void PatientTestNew() 
	{
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
	
	@Test
	public void PatientTestRead() 
	{
		String[][] db = EMRDbConn.retreive("select * from patient",4);
		Random rand = new Random();
		int randomID = rand.nextInt(db.length);
		
		Patient p = new Patient(db[randomID][0]);
		Assert.assertTrue(p.getPatientID() != null);
	}
	
	@Test
	public void PatientTestDelete() 
	{
		String[][] db = EMRDbConn.retreive("select * from patient",4);
		Random rand = new Random();
		int randomID = rand.nextInt(db.length);
		
		Patient p = new Patient(db[randomID][0]);
		String patientID = p.getPatientID();
		String patientName = p.getPatientName();
		String dOfB = p.getDofB();
		String homeBranch = p.getHomeBranch();
		
		p.removePatient();
		
		Patient p2 = new Patient(db[randomID][0]);
		Assert.assertTrue(p2.getPatientID() == null);
		
		Patient pNew = new Patient(patientID,patientName,dOfB,homeBranch);
	}
}
