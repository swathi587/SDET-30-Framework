package CreateUpdateGenericTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateCamProduGeneTest 
{
@Test
	
	public void createCampaignTest() throws Throwable
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
				
			 String Product = eLib.readDataFromExcel("Product", 1, 1)+" "+jLib.getRandomnumber();	
			
		
			 String Campaign = eLib.readDataFromExcel("Product", 1, 2)+" "+jLib.getRandomnumber();	
				
				
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
				
				//Product
				driver.findElement(By.linkText("Products")).click();
				driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
				driver.findElement(By.name("productname")).sendKeys(Product);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Header of Product---Verifying
				String header = driver.findElement(By.className("lvtHeaderText")).getText();
				if(header.contains(Product))
				{
					System.out.println(header);
					System.out.println("prg created");
				}
				else
				{
					System.out.println(header);
					System.out.println("pgm not created");
				}
				
				//Campaign
				WebElement we1 = driver.findElement(By.xpath("//a[@href='javascript:;']"));
				wLib.mouseHover(driver, we1);
				
				wLib.switchToWindow(driver, header);
			
				driver.findElement(By.name("Campaigns")).click();
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
				driver.findElement(By.name("campaignname")).sendKeys(Campaign);
				
				driver.findElement(By.xpath("//img[@alt='Select']")).click();
				
				

				Set<String> win1 = driver.getWindowHandles();
				for(String wi : win1)
				{
					driver.switchTo().window(wi);
				}
				
driver.findElement(By.name("search_text")).sendKeys(Product);
				
				driver.findElement(By.name("search")).click();
				
				driver.findElement(By.xpath("//a[text()='"+Product+"']")).click();
				
				
				Set<String> win = driver.getWindowHandles();
				for(String winId:win)  
				{
					driver.switchTo().window(winId);
				}
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				String campHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(campHeader.contains(Campaign))
				{
					System.out.println(campHeader +" camp created");
				}
				else
				{
					System.out.println("camp not created");
				}
				

			
				/*Step 7: logout of application*/
				//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				
				//wLib.mouseHover(driver, ele);
				//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
				
				/*Step 8: close the browser*/
				driver.quit();
	}
}
