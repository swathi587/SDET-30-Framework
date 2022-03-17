package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	@Test
	public void sampleJDBCExecuteUpdate() throws Throwable
	{
		Connection con=null;
		try{
		//step 1:register the database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2: getconnnector from database-- provide db name
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		
		//step 3 :issue create statement
		Statement state = con.createStatement();
		
		//step 4 : execute query
		//insert into students values(4,'Gayathri','Female');
		int result = state.executeUpdate("insert into students values(5,'Anand','Male');");
		if(result==1)
		{
			System.out.println("Data added successfully");
		}
		else
		{
			System.out.println("Data is not added");
		}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
		//step 5: close database
		con.close();
		System.out.println("Connection closed");
		}
	}

}
