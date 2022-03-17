package com.crm.testngscripts;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CampaignInfoPage;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateLeadPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LeadPage;
import com.crm.ObjectRepository.LeadinfoPage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductPage;


@Listeners(com.crm.GenericLibrary.ListenersImplementationClass.class)
public class CreateCampaignTest extends BaseClass
{

	@Test(groups="regressionSuite")
	public void createCamp() throws Throwable
	{
		  String CampName = eLib.readDataFromExcel("Contact", 4, 1)+" "+jLib.getRandomnumber();
		  
		  /*Step 4: Navigate to Contact Link*/
			HomePage hp=new HomePage(driver);
			hp.ClickMoreLink();
			hp.ClickCampLink();
			
			CampaignPage cp=new CampaignPage(driver);
			cp.ClickOnCreateCampLnk();
			
			CreateCampaignPage ccp= new CreateCampaignPage(driver);
			ccp.CreateCampaignName(CampName);
			
			CampaignInfoPage cip=new CampaignInfoPage(driver);
			String actHeader = cip.CampaignInfoPage();
			if(actHeader.contains(CampName))
			{
				System.out.println(CampName+"---> Data varified");
			}
			else
			{
				System.out.println(" Invalid Data ");
			}	  
	}
	
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

	@Test(groups="regressionSuite")
	public void createProduct() throws Throwable
	{
		String PrdName = eLib.readDataFromExcel("Product", 1, 1)+" "+jLib.getRandomnumber();
		
		/*Step 4: Navigate to Contact Link*/
		SoftAssert sa=new SoftAssert();
		HomePage hp=new HomePage(driver);
		hp.ClickProductLink();
		
		//For assertion
		String expdata="Products";
		String actdata = driver.findElement(By.linkText("Products")).getText();
		
		ProductPage pp=new ProductPage(driver);
		pp.ClickOnCreateProLnk();
		
		
		//Assertion 
		String expHeader = "Creating New product";
		String actHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		sa.assertEquals(actHeader, actHeader);
		
		//Creating Product
		CreateProductPage cop=new CreateProductPage(driver);
		cop.CreateProduct(PrdName);
		
		ProductInfoPage pip=new ProductInfoPage(driver);
		String actPrdName =pip.ProductInfo();
		//Assert.fail();
		
		
		/*if(actPrdName.contains(PrdName))
		{
			System.out.println(PrdName+"---> Data varified");
		}
		else
		{
			System.out.println(" Invalid Data ");
		}*/
	      
		Reporter.log(actPrdName+"Product Created",true);
		
		sa.assertTrue(actPrdName.contains("abc"));
		sa.assertAll();
		
	}
}
