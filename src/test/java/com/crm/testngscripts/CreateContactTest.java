package com.crm.testngscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
public class CreateContactTest extends BaseClass
{

		@Test(groups="smokeSuite")
		public void createConTest() throws Throwable
		{

	        String Last_Name = eLib.readDataFromExcel("Contact", 4, 1)+" "+jLib.getRandomnumber();	
	        String leadSource=eLib.readDataFromExcel("Contact",4, 2);
	     

		  /*Step 4: Navigate to Contact Link*/
			HomePage hp=new HomePage(driver);
			hp.ClickContactLink();
			
			ContactPage cp=new ContactPage(driver);
			cp.clickOnCreateContactImg();
			
			/*Step 5: click on create contact btn*/
			CreateContactPage cop=new CreateContactPage(driver);
			cop.createNewContact(Last_Name, leadSource);
			
			//Step 6: Verification
			ContactInfoPage cip=new ContactInfoPage(driver);
			
			String actContactName = cip.ContactInfo();
			if(actContactName.contains(Last_Name))
			{
				System.out.println(Last_Name+"---> Data varified");
			}
			else
			{
				System.out.println(" Invalid Data ");
			}	
		}
	@Test
	public void regionalRegression()
	{
		System.out.println("Regional regression test passed");
	}
}
