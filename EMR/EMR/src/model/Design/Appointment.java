package model.Design;

import model.Helper.EMRDbConn;

public class Appointment
{
	private String AppID;
	private String AppDate;
	private String AppTime;
	private String PatientID;
	private String Branch;
	
	//this is for already existing 
	public Appointment(String id)
	{
		try {
			String[][] db = EMRDbConn.retreive("select * from appointment where AppID = '"+ id +"'",5);
			this.setAppID(db[0][0]);
			this.setPatientID(db[0][1]);
			this.setAppDate(db[0][2]);
			this.setAppTime(db[0][3]);
			this.setBranch(db[0][4]);
		}
		catch(Exception e) {
			
		}
	}
	
	//this is for new
	public Appointment(String id, String patientid, String date, String time, String branch)
	{
		String[] newinsertdata = {id,patientid,date,time,branch};
		EMRDbConn.modify("INSERT INTO appointment (AppID, PatientID, AppDate, AppTime, Branch) VALUES (?, ?, ?, ?, ?)", newinsertdata);
		
		this.setAppID(id);
		this.setAppDate(date);
		this.setAppTime(time);
		this.setPatientID(patientid);
		this.setBranch(branch);
	}
	
	public void updateAppointment(String set, String setvalue)
	{
		
		String updateStatement = "update appointment "
				+ "set "+set+" = '"+setvalue+"'"
				+ "where AppID = '" + this.getAppID() + "'";
				
		EMRDbConn.modify(updateStatement, null);
	}
	
	public void removeAppointment()
	{
		
		String removeStatement = "DELETE * FROM appointment WHERE AppID = '" + this.getAppID() + "'";
		EMRDbConn.modify(removeStatement, null);
	}
	
	public boolean appointmentIsInDB(String idToTest) {
		
		String[][] db = EMRDbConn.retreive("select * from appointment where AppID = '"+ this.getAppID() +"'",5);
		
		if(idToTest.equals(db[0][0]))
			return true;
		
		return false;
	}
	
	public boolean appointmentIsUpdatedDB() {
		//used to check if updates worked on the db
		//update object attributes via set methods after using updateAppointment
		
		String[][] db = EMRDbConn.retreive("select * from appointment where AppID = '"+ this.getAppID() +"'",5);
		
		if(db[0][1].equals(PatientID) && 
				db[0][2].equals(AppDate) && 
				db[0][3].equals(AppTime) && 
				db[0][4].equals(Branch))
			return false;
		
		return true;
	}
	
	public String getAppID()
	{
		return AppID;
	}

	public void setAppID(String id)
	{
		this.AppID = id;
	}

	public String getAppDate()
	{
		return AppDate;
	}

	public void setAppDate(String appDate)
	{
		AppDate = appDate;
	}

	public String getAppTime()
	{
		return AppTime;
	}

	public void setAppTime(String appTime)
	{
		AppTime = appTime;
	}

	public String getPatientID()
	{
		return PatientID;
	}

	public void setPatientID(String patientID)
	{
		PatientID = patientID;
	}

	public String getBranch()
	{
		return Branch;
	}

	public void setBranch(String branch)
	{
		Branch = branch;
	}
		
		
}
