package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPract {

	@Test(dataProvider="getData")
	public void sampleDataProvider(int number, String model)
	{
	System.out.println(number+"--"+model);	
	}

	@DataProvider()
	public Object[][] getData()
	{
	Object[][] obj=new Object[6][2];

	obj[0][0]=1;
	obj[0][1]="hp";


	obj[1][0]=2;
	obj[1][1]="Lenovo";
	

	obj[2][0]=3;
	obj[2][1]="Asus";
	

	obj[3][0]=4;
	obj[3][1]="Dell";
	
	obj[4][0]=5;
	obj[4][1]="Acer";
	
	obj[5][0]=6;
	obj[5][1]="Samsung";
	
	
	
	return obj;	
	}
}
