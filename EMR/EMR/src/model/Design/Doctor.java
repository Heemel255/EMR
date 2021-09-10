package model.Design;

import java.util.ArrayList;

import model.Helper.EMRDbConn;

public class Doctor extends Staff
{
	private String CurrentWard;
	
	//this is for already existing 
		public Doctor(String id)
		{
			String[][] db = EMRDbConn.retreive("select * from doctor where EmpID = '"+ id +"'",8);
			
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
		public Doctor(String id, String fname, String lname, String phone, String email, String ward, String branch, String logid)
		{
			String[] newinsertdata = {id,fname,lname,phone,email,ward,branch, logid};
			EMRDbConn.modify("INSERT INTO doctor (EmpID, FName, LName, PhoneNum, Email, CurrentWard, HomeBranch, LoginID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", newinsertdata);
			
			super.setFName(fname);
			super.setLName(lname);
			super.setPhoneNum(phone);
			super.setEmail(email);
			this.setCurrentWard(ward);
			super.setEmpID(id);
			super.setHomeBranch(branch);
			super.setLoginID(logid);
		}
		
		public static void allUserID(ArrayList<String> aa)
		{
			String[][] db = EMRDbConn.retreive("select * from doctor",8);
			
			
			for(int i=0;i<db.length;i++)
			{
				aa.add(db[i][7]);
			}
		}
		
		public void updateDoctor(String set, String setvalue)
		{
			
			
			String updateStatement = "update doctor "
					+ "set "+set+" = '"+setvalue+"'"
					+ "where EmpID = '" + super.getEmpID() + "'";
					
			EMRDbConn.modify(updateStatement, null);
		}
		
		
		public String getCurrentWard()
		{
			return CurrentWard;
		}

		public void setCurrentWard(String currentWard)
		{
			CurrentWard = currentWard;
		}
}
