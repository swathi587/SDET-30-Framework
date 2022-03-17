package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataVerificationDB {
	@Test
	public void sampleJDBCExecuteQuery () throws Throwable
	{
		String expData = "Gajendra";
		//step 1:register the database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2: getconnnector from database-- provide db name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		
		//step 3 :issue create statement
		Statement state = con.createStatement();
		
		//execute query--> provide tablename
		ResultSet result = state.executeQuery("select * from students;");
		while(result.next())
		{
			String actData = result.getString(2);
			System.out.println(actData);
			if(expData.equalsIgnoreCase(actData))
			{
				System.out.println(actData+"  Data is verified");
				break;
			}
		
		}
		
		//close database
		con.close();
		
	}
}
