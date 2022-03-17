package com.crm.testngscripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateLeadPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LeadPage;
import com.crm.ObjectRepository.LeadinfoPage;


@Listeners(com.crm.GenericLibrary.ListenersImplementationClass.class)

public class CreateLeadTest extends BaseClass
{
	@Test
//@Test(retryAnalyzer=com.crm.GenericLibrary.RetryAnalyzerImplementation.class)
	
//@Test(groups="regressionSuite")
public void createLead() throws Throwable
{
	//String LastName = eLib.readDataFromExcel("Lead", 1, 1)+" "+jLib.getRandomnumber();
	String CompanyName = eLib.readDataFromExcel("Lead", 1, 2);
	String LastName = eLib.readDataFromExcel("Lead", 1, 1);
	
	SoftAssert sa=new SoftAssert();
	/*Step 4: Navigate to Lead Link*/
	HomePage hp=new HomePage(driver);
	hp.ClickLeadLink();

	String expData="Leads";
    String actData = driver.findElement(By.linkText("Leads")).getText();
    sa.assertEquals(expData, actData);
    
	LeadPage op=new LeadPage(driver);
	op.clickOnCreateLeadImg();
	
	String eData = "Creating New Lead";
	String aData = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
sa.assertEquals(aData, aData);
	
	/*Step 5: click on create Lead btn*/
	CreateLeadPage clp=new CreateLeadPage(driver);
	clp.createNewLead(LastName, CompanyName);
	//Assert.fail();
	
	//Step 6: Verification
LeadinfoPage lip=new LeadinfoPage(driver);
	String actLeadName = lip.Leadinfo();
	
	/*
	if(actLeadName.contains(LastName))
	{
		System.out.println(LastName+"---> Data varified");
	}
	else
	{
		System.out.println(" Invalid Data ");
	}
      */
	
	Reporter.log(actLeadName +"lead created",true);
	//sa.assertTrue(actLeadName.contains("Sam"));
	sa.assertTrue(actLeadName.contains("sam"));
	sa.assertAll();
		
}
}
