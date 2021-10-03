package model.Design;

import java.util.ArrayList;

public class Nurse extends Staff
{
	private String CurrentWard;

		//this is for already existing 
		public Nurse(String id)
		{
			//String[][] db = EMRDbConn.retreive("select * from nurse where EmpID = '"+ id +"'",8);
			String[][] db = null;
			
			super.setFName(db[0][1]);
			super.setLName(db[0][1]);
			super.setPhoneNum(db[0][2]);
			super.setEmail(db[0][3]);
			this.setCurrentWard(db[0][4]);
			super.setEmpID(db[0][0]);
			super.setHomeBranch(db[0][6]);
			super.setLoginID(db[0][7]);
		}
		
		//this is for new
		public Nurse(String id, String fname, String lname, String phone, String email, String ward, String branch, String logid)
		{
			String[] newinsertdata = {id,fname,lname,phone,email,ward,branch, logid};
			//EMRDbConn.modify("INSERT INTO nurse (EmpID, FName, LName, PhoneNum, Email, CurrentWard, HomeBranch, LoginID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", newinsertdata);
			
			super.setFName(fname);
			super.setLName(lname);
			super.setPhoneNum(phone);
			super.setEmail(email);
			this.setCurrentWard(ward);
			super.setEmpID(id);
			super.setHomeBranch(branch);
			super.setLoginID(logid);
		}
		
		public void updateNurse(String set, String setvalue)
		{
			
			
			String updateStatement = "update nurse "
					+ "set "+set+" = '"+setvalue+"'"
					+ "where EmpID = '" + super.getEmpID() + "'";
					
			//EMRDbConn.modify(updateStatement, null);
		}
	
		public static void allUserID(ArrayList<String> aa)
		{
			//String[][] db = EMRDbConn.retreive("select * from nurse",8);
			String[][] db = null;
			
			for(int i=0;i<db.length;i++)
			{
				aa.add(db[i][7]);
			}
		}
	
	public String getCurrentWard()
	{
		return CurrentWard;
	}

	public void setCurrentWard(String currentWard)
	{
		this.CurrentWard = currentWard;
	}
	
	
}
