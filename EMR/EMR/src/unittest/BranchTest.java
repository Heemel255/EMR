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
		//1:make new branch by using a random id
		//2:assert it is in db by checking with the created id 
		//3:remove it from db
		
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
		//1:retrieve random id
		//2:make an branch object from it
		//3:update city column in db
		//4:assert if it is updated
		//5:update it again to the original value
		
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
		//1:retrieve random id
		//2:check if id exists and is not null by creating branch object
		String[][] db = EMRDbConn.retreive("select * from branch",2);
		Random rand = new Random();
		int randomID = rand.nextInt(db.length);
		
		Branch br = new Branch(db[randomID][0]);
		Assert.assertTrue(br.getBranchID() != null);
	}
	
	@Test
	public void BranchTestDelete() 
	{
		//1:retrieve random id and create branch object
		//2:store contents of object temporarily
		//3:delete row with retrieved id
		//4:create an object with previous random id, assert it does not exist
		//5:create row again with stored data
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
