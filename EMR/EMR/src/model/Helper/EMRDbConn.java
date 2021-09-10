package model.Helper;

import java.sql.*;


public class EMRDbConn
{
	private static String accdb = "C:\\Users\\heeme\\Documents\\emrdb.accdb";
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static PreparedStatement preparedStatement = null;
	
	
	public static String[][] retreive(String query, int totalColumnsOfTable)
	{
		String[][] returnString = null;
		
		try {
			 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(Exception e) {
 
        }
 
        try {
 
            String dbURL = "jdbc:ucanaccess://" + accdb; 
 
            connection = DriverManager.getConnection(dbURL); 
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            
            ResultSet resultsettemp = statement.executeQuery(query);
            int totalRows=0;
            while(resultsettemp.next()) {
            	totalRows++;
			}
            resultsettemp.close();
            
            returnString = new String[totalRows][totalColumnsOfTable];
            
            int currentRow = 0;
            while(resultSet.next()) {
				
            	for(int i=0;i<totalColumnsOfTable;i++) {
            		
            		returnString[currentRow][i] = resultSet.getString(i+1);
            	}
            	
            	currentRow++;
			}
            
        }
        catch(Exception e){
        
        }
		try {
            if(null != connection) {

                
                statement.close();
                connection.close();
                resultSet.close();
                
            }
        }
        catch (Exception e) {
        	
        }
		
		return returnString;
	}
	
	public static void modify(String query, String[] values)
	{
		try {
			 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(Exception e) {
 
        }
 
        try {
 
            String dbURL = "jdbc:ucanaccess://" + accdb; 
 
            connection = DriverManager.getConnection(dbURL); 
            statement = connection.createStatement();
            
            preparedStatement = connection.prepareStatement(query);
			 
			 if(values != null) {
				 
				 for(int i=0;i<values.length;i++) {
			    	 
			    	 preparedStatement.setString(i+1, values[i]);
			     }
			 }
		     
		     preparedStatement.executeUpdate();
            
        }
        catch(Exception e){
        
        }
		
		try
		{
			
			 if(null != connection) {

	            statement.close();
	            connection.close();
	            preparedStatement.close();
			 }
		}
		catch (SQLException e)
		{
			
		}
	}
}
