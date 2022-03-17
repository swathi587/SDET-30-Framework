package POMScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CampaignInfoPage;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateCampaignTest {

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

        String CampName = eLib.readDataFromExcel("Contact", 4, 1)+" "+jLib.getRandomnumber();	
     	
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
	      
		
		/*Step 7: logout of application*/
		hp.SignOutOfApp(driver);
		
		/*Step 8: close the browser*/
		driver.quit();                                                                                                                                                                 
	}		
	}
	

