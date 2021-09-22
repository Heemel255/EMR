package model.Design;

import java.util.ArrayList;

public class Branch 
{
	private String BranchID;
	private String City;
	
	ArrayList<String> arrWard = new ArrayList<String>();
	
		public Branch(String id)
		{
			try {
				String[][] db = EMRDbConn.retreive("select * from branch where BranchID = '"+ id +"'",2);
				
				this.setBranchID(db[0][0]);
				this.setCity(db[0][1]);
			}
			catch(Exception e) {
				
			}
		}
		
		//this is for new
		public Branch(String id, String city)
		{
			String[] newinsertdata = {id,city};
			EMRDbConn.modify("INSERT INTO branch (BranchID, City) VALUES (?, ?)", newinsertdata);
			
			this.setBranchID(id);
			this.setCity(city);
		}
		
		public void updateBranch(String set, String setvalue)
		{
			
			
			String updateStatement = "update branch "
					+ "set "+set+" = '"+setvalue+"'"
					+ "where BranchID = '" + this.getBranchID() + "'";
					
			EMRDbConn.modify(updateStatement, null);
		}
		
		public void removeBranch()
		{
			
			String removeStatement = "DELETE * FROM branch WHERE BranchID = '" + this.getBranchID() + "'";
			EMRDbConn.modify(removeStatement, null);
		}
		
		public boolean branchIsInDB(String idToTest) {
			
			String[][] db = EMRDbConn.retreive("select * from branch where BranchID = '"+ this.getBranchID() +"'",2);
			
			if(idToTest.equals(db[0][0]))
				return true;
			
			return false;
		}
		
		public boolean branchIsUpdatedDB() {
			//used to check if updates worked on the db
			//update object attributes via set methods after using updateAppointment
			
			String[][] db = EMRDbConn.retreive("select * from branch where BranchID = '"+ this.getBranchID() +"'",2);
			
			if(db[0][1].equals(City))
				return false;
			
			return true;
		}
		
		public void addward(String w) {
			arrWard.add(w);
		}
		
		public void removeward(String w) {
			arrWard.remove(w);
		}

		public String getBranchID()
		{
			return BranchID;
		}

		public void setBranchID(String branchID)
		{
			BranchID = branchID;
		}

		public String getCity()
		{
			return City;
		}

		public void setCity(String city)
		{
			City = city;
		}
		
	
}
