package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractice {

	@Test
	public void propertyFile() throws Throwable
	{
		//Step 1: Read the file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2:Create Obj of Properties
		Properties pObj= new Properties();
		pObj.load(fis);
		
		//Step 3 : Read the data
		String URL=pObj.getProperty("username");
		
		//verification
		System.out.println(URL);
	}
}
