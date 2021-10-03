package model.Design;

abstract public class Staff
{
	private String EmpID;
	private String FName;
	private String LName;
	private String PhoneNum;
	private String Email;
	private String HomeBranch;
	private String LoginID;
	
	public String getEmpID()
	{
		return EmpID;
	}
	public void setEmpID(String empID)
	{
		EmpID = empID;
	}
	public String getFName()
	{
		return FName;
	}
	public void setFName(String fName)
	{
		FName = fName;
	}
	public String getLName()
	{
		return LName;
	}
	public void setLName(String lName)
	{
		LName = lName;
	}
	public String getPhoneNum()
	{
		return PhoneNum;
	}
	public void setPhoneNum(String phoneNum)
	{
		PhoneNum = phoneNum;
	}
	public String getEmail()
	{
		return Email;
	}
	public void setEmail(String email)
	{
		Email = email;
	}
	public String getHomeBranch()
	{
		return HomeBranch;
	}
	public void setHomeBranch(String homeBranch)
	{
		HomeBranch = homeBranch;
	}
	public String getLoginID()
	{
		return LoginID;
	}
	public void setLoginID(String loginID)
	{
		LoginID = loginID;
	}
	

}
