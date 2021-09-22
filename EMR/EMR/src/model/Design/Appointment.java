package model.Design;

import java.util.List;

import model.Helper.MySQLConn;

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
			String q = "select * from appointment where AppID='" + id + "'";
			
			this.setAppID(MySQLConn.Retrieve(q, "AppID").get(0));
			this.setPatientID(MySQLConn.Retrieve(q, "PatientID").get(0));
			this.setAppDate(MySQLConn.Retrieve(q, "AppDate").get(0));
			this.setAppTime(MySQLConn.Retrieve(q, "AppTime").get(0));
			this.setBranch(MySQLConn.Retrieve(q, "Branch").get(0));
		}
		catch(Exception e) {
			
		}
	}
	
	//this is for new
	public Appointment(String id, String patientid, String date, String time, String branch)
	{
		MySQLConn.Modify("INSERT INTO appointment " + "VALUES ('" +id+ "', '" +patientid+ "', '" +date+ "', '" +time+ "', '" +branch+ "')");
		
		this.setAppID(id);
		this.setAppDate(date);
		this.setAppTime(time);
		this.setPatientID(patientid);
		this.setBranch(branch);
	}
	
	public void updateAppointment(String set, String setvalue)
	{
		
		String updateStatement = "UPDATE appointment "
				+ "SET "+set+" = '"+setvalue+"'"
				+ "WHERE AppID = '" + this.getAppID() + "'";
				
		MySQLConn.Modify(updateStatement);
	}
	
	public void removeAppointment()
	{
		
		String removeStatement = "DELETE FROM appointment WHERE AppID = '" + this.getAppID() + "'";
		MySQLConn.Modify(removeStatement);
	}
	
	public boolean appointmentIsInDB(String idToTest) 
	{
		
		String q = "select * from appointment where AppID='" + idToTest + "'";
		String id = MySQLConn.Retrieve(q, "AppID").get(0);
		
		if(idToTest.equals(id))
			return true;
		
		return false;
	}
	
	public boolean appointmentIsUpdatedDB() {
		
		//String[][] db = EMRDbConn.retreive("select * from appointment where AppID = '"+ this.getAppID() +"'",5);
		
		String q = "select * from appointment where AppID='" + this.getAppID() + "'";
		String pid = MySQLConn.Retrieve(q, "PatientID").get(0);
		String appd = MySQLConn.Retrieve(q, "AppDate").get(0);
		String appt = MySQLConn.Retrieve(q, "AppTime").get(0);
		String br = MySQLConn.Retrieve(q, "Branch").get(0);
		
		if(pid.equals(PatientID) && 
				appd.equals(AppDate) && 
				appt.equals(AppTime) && 
				br.equals(Branch))
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
