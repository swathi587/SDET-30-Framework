package com.crm.testngscripts;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.IpathConstanants;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrgWithMultipleDataTest
{
    //Create Object for all Utilities
	PropertyFileUtility pLib = new PropertyFileUtility();
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	JavaUtility jLib = new JavaUtility();
	
	@Test(dataProvider = "OrgTestData")
	public void createOrgWithMltipleData(String orgName, String indType) throws Throwable
	{

	
	//read data 
	String BROWSER = pLib.readDataFromPropertyFile("browser");
	String URL = pLib.readDataFromPropertyFile("url");
	String USERNAME = pLib.readDataFromPropertyFile("username");
	String PASSWORD = pLib.readDataFromPropertyFile("password");
	
	String orgname =orgName+" "+jLib.getRandomnumber();
	
	//launch the application
			WebDriver driver = null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("FIREFOX"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("invalid browser");
			}
			
			wLib.maximizeWindow(driver);
			wLib.waitForPageLoad(driver);
			driver.get(URL);
			
			//login to application
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			Reporter.log("login successful",true);
			
			//navigate to organization
			HomePage hp = new HomePage(driver);
			hp.ClickOrgLink();
			Reporter.log("navigated to org link",true);
			
			//create Org
			OrganizationPage op = new OrganizationPage(driver);
			op.clickOnCreateOrgImg();
			Reporter.log("click on create org link",true);
			
			//create new org
			CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			cop.createNewOrg(orgname, indType);
			Reporter.log("create org with industry type",true);
			
			//validate
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String actHeader = oip.OrgNameInfo();
			if (actHeader.contains(orgname)) {
				System.out.println("passed");
			}
			else
			{
				System.out.println("failed");
			}
			Reporter.log("verification successful",true);		
			
			//logout
			hp.SignOutOfApp(driver);
			
			driver.quit();
	}
	@DataProvider(name="OrgTestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data1=eLib.readmultipleDataPrFromExcel("Organ");
		return data1;
	}
	

}
