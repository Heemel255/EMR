package model.Design;

import model.Helper.EMRDbConn;

public class Patient
{
	private String PatientID;
	private String PatientName;
	private String DofB;
	private String HomeBranch;
	
	//this is for already existing 
	public Patient(String id)
	{
		try {
			String[][] db = EMRDbConn.retreive("select * from patient where PatientID = '"+ id +"'",4);
			
			this.setPatientID(db[0][0]);
			this.setPatientName(db[0][1]);
			this.setDofB(db[0][2]);
			this.setHomeBranch(db[0][3]);
		}
		catch(Exception e) {
			
		}
	}
	
	//this is for new
	public Patient(String id, String name, String DofB, String branch)
	{
		String[] newinsertdata = {id,name,DofB, branch};
		EMRDbConn.modify("INSERT INTO patient (PatientID, PatientName, DoB, HomeBranch) VALUES (?, ?, ?, ?)", newinsertdata);
		
		this.setPatientID(id);
		this.setPatientName(name);
		this.setDofB(DofB);
		this.setHomeBranch(branch);
	}
	
	public void updatePatient(String set, String setvalue)
	{
		
		
		String updateStatement = "update patient "
				+ "set "+set+" = '"+setvalue+"'"
				+ "where PatientID = '" + this.getPatientID() + "'";
				
		EMRDbConn.modify(updateStatement, null);
	}
	
	public void removePatient()
	{
		
		String removeStatement = "DELETE * FROM patient WHERE PatientID = '" + this.getPatientID() + "'";
		EMRDbConn.modify(removeStatement, null);
	}
	
	public boolean patientIsInDB(String idToTest) {
		
		String[][] db = EMRDbConn.retreive("select * from patient where PatientID = '"+ this.getPatientID() +"'",4);
		
		if(idToTest.equals(db[0][0]))
			return true;
		
		return false;
	}
	
	public boolean patientIsUpdatedDB() {
		//used to check if updates worked on the db
		//update object attributes via set methods after using updateAppointment
		
		String[][] db = EMRDbConn.retreive("select * from patient where PatientID = '"+ this.getPatientID() +"'",4);
		
		if(db[0][1].equals(PatientName) && 
				db[0][2].equals(DofB) && 
				db[0][3].equals(HomeBranch))
			return false;
		
		return true;
	}
	
	
	public String getPatientID()
	{
		return PatientID;
	}
	public void setPatientID(String patientID)
	{
		PatientID = patientID;
	}
	public String getPatientName()
	{
		return PatientName;
	}
	public void setPatientName(String patientName)
	{
		PatientName = patientName;
	}
	public String getDofB()
	{
		return DofB;
	}
	public void setDofB(String dofB)
	{
		DofB = dofB;
	}

	public String getHomeBranch()
	{
		return HomeBranch;
	}

	public void setHomeBranch(String homeBranch)
	{
		HomeBranch = homeBranch;
	}
	
}
