package model.Design;

import java.util.ArrayList;

import model.Helper.EMRDbConn;

public class Ward
{
	private String WardID;
	private String Branch;
	private String Capacity;
	private String CapAvailable;
	private String CapTaken;
	
	ArrayList<String> arrPatient = new ArrayList<String>();
	

	public Ward(String id)
	{
		String[][] db = EMRDbConn.retreive("select * from ward where WardID = '"+ id +"'",5);
		
		this.setWardID(db[0][0]);
		this.setBranch(db[0][1]);
		this.setCapacity(db[0][4]);
		this.setCapAvailable(db[0][2]);
		this.setCapTaken(db[0][3]);
	}
	
	
	public Ward(String id, String city)
	{
		String[] newinsertdata = {id,city};
		EMRDbConn.modify("INSERT INTO ward (WardID, Branch, Capacity, CapAvailable, CapTaken) VALUES (?, ?, ?, ?, ?)", newinsertdata);
		
		
	}
	
	public void updateBranch(String set, String setvalue)
	{
		String updateStatement = "update ward "
				+ "set "+set+" = '"+setvalue+"'"
				+ "where WardID = '" + this.getWardID() + "'";
				
		EMRDbConn.modify(updateStatement, null);
	}
	
	public void addpatient(String w) {
		arrPatient.add(w);
	}
	
	public void removepatient(String w) {
		arrPatient.remove(w);
	}

	public String getWardID()
	{
		return WardID;
	}

	public void setWardID(String wardID)
	{
		WardID = wardID;
	}

	public String getBranch()
	{
		return Branch;
	}

	public void setBranch(String branch)
	{
		Branch = branch;
	}

	public String getCapacity()
	{
		return Capacity;
	}

	public void setCapacity(String capacity)
	{
		Capacity = capacity;
	}

	public String getCapAvailable()
	{
		return CapAvailable;
	}

	public void setCapAvailable(String capAvailable)
	{
		CapAvailable = capAvailable;
	}

	public String getCapTaken()
	{
		return CapTaken;
	}

	public void setCapTaken(String capTaken)
	{
		CapTaken = capTaken;
	}
}
