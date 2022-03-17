 package com.crm.PRACTICE;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest {

	@Test
	public void readDataFromCmdLine()
	{
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		System.out.println("Browser name is -->"+BROWSER);
		System.out.println("Url is -->"+URL);
		System.out.println("Username is -->"+USERNAME);
		System.out.println("Password is -->"+PASSWORD);
	}
}
