package model.Design;

import java.util.ArrayList;

import model.Helper.EMRDbConn;

public class MedicalRecord
{
	private String ID;
	private String patientid;
	private String doctorid;
	private String assessdate;
	private String diagnosis;
	private String prescription;
	
	public MedicalRecord(String id)
	{
		String[][] db = EMRDbConn.retreive("select * from MedicalRecords where ID = '"+ id +"'",6);
		this.setID(db[0][0]);
		this.setPatientid(db[0][1]);
		this.setDoctorid(db[0][2]);
		this.setAssessdate(db[0][5]);
		this.setDiagnosis(db[0][3]);
		this.setPrescription(db[0][4]);
	}
	
	public MedicalRecord(String id, String patientid, String doctorid, String accessdate, String diagnosis, String prescription)
	{
		String[] newinsertdata = {id,patientid,doctorid,accessdate,diagnosis,prescription};
		EMRDbConn.modify("INSERT INTO MedicalRecords (ID, PatientID, DoctorID, AssessDate, Diagnosis, Prescription) VALUES (?, ?, ?, ?, ?, ?)", newinsertdata);
		
		this.setID(id);
		this.setPatientid(patientid);
		this.setDoctorid(doctorid);
		this.setAssessdate(accessdate);
		this.setDiagnosis(diagnosis);
		this.setPrescription(prescription);
	}
	
	public static void allRecords(ArrayList<String> aa, String patientid)
	{
		String[][] db = EMRDbConn.retreive("select * from MedicalRecords where PatientID = '"+ patientid +"'",6);
		
		
		for(int i=0;i<db.length;i++)
		{
			aa.add("AssessDate: " + db[i][5] + "\nDiagnosis: " + db[i][3] + "\nPrescription: " + db[i][4]);
		}
	}
	
	public void updateRecord(String set, String setvalue)
	{
		
		
		String updateStatement = "update MedicalRecords "
				+ "set "+set+" = '"+setvalue+"'"
				+ "where ID = '" + this.getID() + "'";
				
		EMRDbConn.modify(updateStatement, null);
	}

	public String getID()
	{
		return ID;
	}

	public void setID(String iD)
	{
		ID = iD;
	}

	public String getPatientid()
	{
		return patientid;
	}

	public void setPatientid(String patientid)
	{
		this.patientid = patientid;
	}

	public String getDoctorid()
	{
		return doctorid;
	}

	public void setDoctorid(String doctorid)
	{
		this.doctorid = doctorid;
	}

	public String getAssessdatee()
	{
		return assessdate;
	}

	public void setAssessdate(String accessdate)
	{
		this.assessdate = accessdate;
	}

	public String getDiagnosis()
	{
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis)
	{
		this.diagnosis = diagnosis;
	}

	public String getPrescription()
	{
		return prescription;
	}

	public void setPrescription(String prescription)
	{
		this.prescription = prescription;
	}
}
