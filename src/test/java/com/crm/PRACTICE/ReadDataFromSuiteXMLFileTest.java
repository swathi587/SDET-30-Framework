package com.crm.PRACTICE;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromSuiteXMLFileTest {
	
	@Test
	public void readDataFromSuiteXMLFileTest(XmlTest xml)
	{
		String BROWSER = xml.getParameter("browser");
		String URL = xml.getParameter("url");
		String USERNAME = xml.getParameter("username");
		String PASSWORD = xml.getParameter("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
	}

}
