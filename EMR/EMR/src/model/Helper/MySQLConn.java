package model.Helper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLConn {
	
	public static void Modify(String statement)
	{
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emr_db", "root","testpass");
			
			Statement stat = conn.createStatement();
			
			stat.executeUpdate(statement);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static List<String> Retrieve(String statement, String column)
	{
		try {
			List<String> r = new ArrayList<String>();
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emr_db", "root","testpass");
			
			Statement stat = conn.createStatement();
			
			ResultSet set = stat.executeQuery(statement);
			
			while(set.next())
				r.add(set.getString(column));
			
			return r;
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
}
