package POMScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import com.crm.ObjectRepository.OrganizationInfoPage;

public class CreateContactName {
	@Test
	public void createConTest() throws Throwable
	{
		JavaUtility jLib=new JavaUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		//Read the data from all necessary files
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");

        String Last_Name = eLib.readDataFromExcel("Contact", 4, 1)+" "+jLib.getRandomnumber();	
        String leadSource=eLib.readDataFromExcel("Contact",4, 2);
        
		
		/*Step 2: launch the browser*/
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
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
		
		/*Step 3: login to application*/
	  LoginPage lp=new LoginPage(driver);
	  lp.loginToApp(USERNAME, PASSWORD);

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
	      
		
		/*Step 7: logout of application*/
		hp.SignOutOfApp(driver);
		
		/*Step 8: close the browser*/
		driver.quit();  
	}
}
