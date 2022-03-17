package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice 
{
@Test(dataProvider="getData")
public void sampleDataProvider(String Name, String model, int Qty)
{
System.out.println(Name+"--"+model+"--"+Qty);	
}

@DataProvider()
public Object[][] getData()
{
Object[][] obj=new Object[4][3];

obj[0][0]="Mi";
obj[0][1]="17 Max";
obj[0][2]=25;

obj[1][0]="Vivo";
obj[1][1]="34 pro";
obj[1][2]=12;

obj[2][0]="MicroMax";
obj[2][1]="11 Max";
obj[2][2]=15;

obj[3][0]="Moto";
obj[3][1]="E4 plus";
obj[3][2]=13;
return obj;	
}
}

