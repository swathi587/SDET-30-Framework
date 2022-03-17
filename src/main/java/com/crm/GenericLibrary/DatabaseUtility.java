package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;



/**
 * This class consisting of all generic methods related to Database 
 * @author Swathi G S
 *
 */
public class DatabaseUtility 
{
  Connection con=null;
	/**
	 * This method will register the Database and establish connection with database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		DriverManager.getConnection(IpathConstanants.dbUrl,IpathConstanants.dbUsername,IpathConstanants.dbPassword);
	}
	
	/**
	 * This method will close the Database
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable 
	{
		con.close();
	}
	
	/**
	 * This method will execute query and return the matching data to the user
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndgetData(String query,int columnIndex, String expData) throws Throwable
	{
		String data=null;
		boolean flag = false;
		
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			data=result.getString(columnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;//flag rising
				break;
			}
		}
		if(flag)
		{
			System.out.println(data+"--->Data verified");
			return expData;
		}
		else
		{
			System.out.println("Data is not verified");
			return "";
		}
		
	}
	
}
