package POMScripts;

	import java.io.FileInputStream;

	import java.io.FileNotFoundException;
	import java.util.Properties;
	import java.util.Random;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	import com.crm.GenericLibrary.ExcelUtility;
	import com.crm.GenericLibrary.JavaUtility;
	import com.crm.GenericLibrary.PropertyFileUtility;
	import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;
	


	public class CreateOrgName {
		@Test
		public void createOrgName() throws Throwable
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
			
			String OrgName = eLib.readDataFromExcel("Org", 4, 2)+" "+jLib.getRandomnumber();
			String indtype = eLib.readDataFromExcel("Org", 4, 3);
			
			
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
			
			/*Step 4: Navigate to Organizations Link*/
			HomePage hp=new HomePage(driver);
			hp.ClickOrgLink();
		
			OrganizationPage op=new OrganizationPage(driver);
			op.clickOnCreateOrgImg();
			
			
			/*Step 5: click on create orgnization btn*/
			CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName, indtype);
			
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
		      
			
			/*Step 7: logout of application*/
			hp.SignOutOfApp(driver);
			
			/*Step 8: close the browser*/
			driver.quit();                                                                                                                                                                 
		}

	}


