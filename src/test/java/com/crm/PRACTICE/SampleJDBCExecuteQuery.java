package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	@Test
	public void sampleJDBCExecuteQuery () throws Throwable
	{
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
		System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));	
		}
		
		//close database
		con.close();
		
	}
}
