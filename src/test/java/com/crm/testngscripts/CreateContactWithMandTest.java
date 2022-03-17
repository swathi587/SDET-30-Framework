package com.crm.testngscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateContactWithMandTest {


	 //Create Object for all Utilities
		PropertyFileUtility pLib = new PropertyFileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
	@Test(dataProvider="OrgTestData")
	public void contactWithMand(String LastName) throws Throwable
	{
		
		//read data 
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		String lastname =LastName;
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
		
		//navigate to contact
		HomePage hp = new HomePage(driver);
		hp.ClickContactLink();
		Reporter.log("navigated to contact link",true);
		
		ContactPage cp=new ContactPage(driver);
		cp.clickOnCreateContactImg();
		Reporter.log("click on create contact link",true);
		
		/*Step 5: click on create contact btn*/
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createNewContact( LastName);
		Reporter.log("create contact",true);
		
		//Step 6: Verification
		ContactInfoPage cip=new ContactInfoPage(driver);
		
		String actContactName = cip.ContactInfo();
		if(actContactName.contains(LastName))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
	      
		Reporter.log("verification successful",true);		
		
		//logout
		hp.SignOutOfApp(driver);
		
		driver.quit();
}
@DataProvider(name="OrgTestData")
public Object[][] getData() throws Throwable
{
	Object[][] data1=eLib.readmultipleDataPrFromExcel("Cont");
	return data1;
}

}
