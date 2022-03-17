package CreateUpdateGenericTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateNewLeadByValidNoOfEmployeeGeneTest {

	@Test
	
	public void createNewLeadByValidNoOfEmployeeGeneTest() throws Throwable
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
		
		String Lead = eLib.readDataFromExcel("Lead", 6, 1)+" "+jLib.getRandomnumber();	
		  String Company =eLib.readDataFromExcel("Lead", 6, 2)+" "+jLib.getRandomnumber();
		 double NoE = eLib.readNumDataFromExcel("Lead", 6, 3);
		 
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
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//Step 4: Click on Lead and create lead
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
			
			//Step 5: Enter Lead and Company
			driver.findElement(By.name("lastname")).sendKeys(Lead);
			driver.findElement(By.name("company")).sendKeys(Company);

			//Number of employees
			driver.findElement(By.name("noofemployees")).sendKeys(Integer.toString((int)NoE));
			 
			//step 6: Click on Save
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				
				/*Step 7: logout of application*/
				//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				
				//wLib.mouseHover(driver, ele);
				//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
				
				/*Step 8: close the browser*/
				driver.quit();
			
		 
	}
}
