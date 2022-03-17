package CreateCampaignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class CreateCampaignTest {

	@Test
	
	public void createCampaignTest() throws Throwable
	{
		
		/*generate random number*/
		Random ran = new Random();
		int random = ran.nextInt(500);
		
		//Read the data from all necessary files
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
				Properties pObj = new Properties();
				pObj.load(fis);
				String BROWSER = pObj.getProperty("browser");
				String URL = pObj.getProperty("url");
				String USERNAME = pObj.getProperty("username");
				String PASSWORD = pObj.getProperty("password");
				
				
				//read data from excel sheet
				FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Excel.xlsx");
				Workbook wb = WorkbookFactory.create(fi);
				Sheet sh = wb.getSheet("Product");
				Row ro = sh.getRow(1);
				Cell cel = ro.getCell(1);
				String PrdName = cel.getStringCellValue();
				String PrdNameRnd = PrdName+" "+random;
				
		Cell ce = ro.getCell(2);
				String Camp= ce.getStringCellValue()+random;
				
				
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
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(URL);
				
				/*Step 3: login to application*/
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//Product
				driver.findElement(By.linkText("Products")).click();
				driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
				driver.findElement(By.name("productname")).sendKeys(PrdNameRnd);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Header of Product---Verifying
				String header = driver.findElement(By.className("lvtHeaderText")).getText();
				if(header.contains(PrdNameRnd))
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
				Actions act=new Actions(driver);
				act.moveToElement(we1).perform();
				
				Set<String> wh = driver.getWindowHandles();
				for(String st:wh)
				{
					driver.switchTo().window(st);
				}
			
				driver.findElement(By.name("Campaigns")).click();
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
				driver.findElement(By.name("campaignname")).sendKeys(Camp);
				
				driver.findElement(By.xpath("//img[@alt='Select']")).click();
				
				

				Set<String> win1 = driver.getWindowHandles();
				for(String wi : win1)
				{
					driver.switchTo().window(wi);
				}
driver.findElement(By.name("search_text")).sendKeys(PrdNameRnd);
				
				driver.findElement(By.name("search")).click();
				
				driver.findElement(By.xpath("//a[text()='"+PrdNameRnd+"']")).click();
				
				
				Set<String> win = driver.getWindowHandles();
				for(String winId:win)  
				{
					driver.switchTo().window(winId);
				}
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				String campHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(campHeader.contains(Camp))
				{
					System.out.println(campHeader +" camp created");
				}
				else
				{
					System.out.println("camp not created");
				}
				

			
				
				/*Step 11: logout and close the browser*/
				WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act1 = new Actions(driver);
				act1.moveToElement(element).perform();
				
				driver.findElement(By.linkText("Sign Out")).click();
				driver.quit();
				
				
				
			//river.findElement(By.name("button")).click();
				
				
				
				
				
				
				

				
			//step9: choose org 
				
				

				
			//tep 10: verfify for Campaign
				
				
				
				
				
				
				
			
	}
}
