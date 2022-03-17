package POMScripts;

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
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateContactWithOrg {
	@Test
	public void createContactWithOrg() throws Throwable
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
        String OrgName=eLib.readDataFromExcel("Contact",4, 3)+" "+jLib.getRandomnumber();
        
		
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
		hp.ClickOrgLink();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		
		CreateOrganizationPage cop=new  CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName);
		
		//Step 6: Verification
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName = oip.OrgNameInfo();
		if(actOrgName.contains(OrgName))
		{
			System.out.println(OrgName+"---> Data varified");
		}
		else
		{
			System.out.println(" Invalid Data ");
		}
	      
		hp.ClickContactLink();
		
		ContactPage cp=new ContactPage(driver);
		cp.clickOnCreateContactImg();
		
		/*Step 5: click on create contact btn*/
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createNewContact(driver, Last_Name, OrgName);
		
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
