package CreateOrganizationTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateOrganizationWithPropertyFileTest
{
   @Test
   public void createOrgTest() throws Throwable
   {
	   //Step 1: Read data from Property file
	   FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	    Properties pObj=new Properties();
	   pObj.load(fis);
	   
	  String BROWSER = pObj.getProperty("browser");
	   String URL = pObj.getProperty("url");
	   String USERNAME = pObj.getProperty("username");
	   String PASSWORD = pObj.getProperty("password");
	   
	      //Step 2: laaunch the browser
	   WebDriver driver=null;
	   if(BROWSER.equalsIgnoreCase("chrome"))
	   {
		   driver=new ChromeDriver();
	   }
	   else if(BROWSER.equalsIgnoreCase("Firefox"))
	   {
		   driver=new FirefoxDriver();
	   }
	   else
	   {
		   System.out.println("Invalid Browser");
	   }
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(URL);
	//Step3: lon
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	//Step 3 : Navigate to Organization link
	driver.findElement(By.linkText("Organizations")).click();
	//Step4 : Click on Organization link
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	//Step4 : Create org with mandatory fields
	driver.findElement(By.name("accountname")).sendKeys("ALL STATES");
	//Step 5: Save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	driver.quit();
   }
}
