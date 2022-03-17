package POMScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateLeadPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LeadPage;
import com.crm.ObjectRepository.LeadinfoPage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateLead 
{
	@Test
	public void createLeadName() throws Throwable
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
		
		String LastName = eLib.readDataFromExcel("Lead", 1, 1)+" "+jLib.getRandomnumber();
		String CompanyName = eLib.readDataFromExcel("Lead", 1, 2);
		
		
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
		lp.loginToApp(USERNAME , PASSWORD);
		
		/*Step 4: Navigate to Lead Link*/
		HomePage hp=new HomePage(driver);
		hp.ClickLeadLink();
	
		LeadPage op=new LeadPage(driver);
		op.clickOnCreateLeadImg();
		
		
		/*Step 5: click on create Lead btn*/
		CreateLeadPage clp=new CreateLeadPage(driver);
		clp.createNewLead(LastName, CompanyName);
		
		//Step 6: Verification
	LeadinfoPage lip=new LeadinfoPage(driver);
		String actLeadName = lip.Leadinfo();
		if(actLeadName.contains(LastName))
		{
			System.out.println(LastName+"---> Data varified");
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
