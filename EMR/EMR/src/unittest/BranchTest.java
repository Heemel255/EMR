package unittest;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.Design.Appointment;
import model.Design.Branch;
import model.Helper.EMRDbConn;

public class BranchTest {
	
	@Test
	public void BranchTestNew() 
	{
		
		String[][] db = EMRDbConn.retreive("select * from branch",2);
		Random rand = new Random();
		int randomID = db.length + rand.nextInt(10);
		
		String id = "UnitTestID" + randomID;
		
		Branch br = new Branch(id,"test");
		
		Assert.assertTrue(br.branchIsInDB(id));
		br.removeBranch();
	}
	
	@Test
	public void BranchTestUpdate() 
	{
		
		String[][] db = EMRDbConn.retreive("select * from branch",2);
		Random rand = new Random();
		int randomID = rand.nextInt(db.length);
		
		Branch br = new Branch(db[randomID][0]);
		String originalCityName = db[randomID][1];
		String newCityName = "UnitTestCity1";
		
		br.updateBranch("City", newCityName);
		
		Assert.assertTrue(br.branchIsUpdatedDB());
		br.updateBranch("City", originalCityName);
	}
	
	@Test
	public void BranchTestRead() 
	{
		
		String[][] db = EMRDbConn.retreive("select * from branch",2);
		Random rand = new Random();
		int randomID = rand.nextInt(db.length);
		
		Branch br = new Branch(db[randomID][0]);
		Assert.assertTrue(br.getBranchID() != null);
	}
	
	@Test
	public void BranchTestDelete() 
	{
		
		String[][] db = EMRDbConn.retreive("select * from branch",2);
		Random rand = new Random();
		int randomID = rand.nextInt(db.length);
		
		Branch br = new Branch(db[randomID][0]);
		String branchID = br.getBranchID();
		String city = br.getCity();
		
		br.removeBranch();
		
		Branch br2 = new Branch(db[randomID][0]);
		Assert.assertTrue(br2.getBranchID() == null);
		
		Branch brNew = new Branch(branchID,city);
	}
}
