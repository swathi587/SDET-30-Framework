package CreateLeadTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateNewLeadByGivingInvalidEmailAndSecondaryEmailTest {

	@Test
	
	public void createNewLeadByGivingInvalidEmailAndSecondaryEmailTest() throws Throwable, IOException
	{
		//Step 1: Create Random numbers
		Random ran=new Random();
		int rand = ran.nextInt();
		
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
		Sheet sh = wb.getSheet("Lead");
		Row ro = sh.getRow(12);
		Cell cel = ro.getCell(1);
		String Lead = cel.getStringCellValue();
		
		Cell cel1 = ro.getCell(2);
		String Company = cel1.getStringCellValue();
		
		
		 Cell cel2= ro.getCell(3);
		 String email = cel2 .getStringCellValue();
		 
		 Cell cel3= ro.getCell(4);
		 String Secemail = cel3.getStringCellValue();
		
		
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
		
		//Step 4: Click on Lead and create lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
	
		//Step 5: Enter Lead and Company
		driver.findElement(By.name("lastname")).sendKeys(Lead+" "+rand);
		driver.findElement(By.name("company")).sendKeys(Company);
		
		//Enter email and secondary email
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("secondaryemail")).sendKeys(Secemail);
		
		if(email.equals(Secemail))
		{
			System.out.println("Both emailId should not be same");
		}
		//click on save
		//step 6: Click on Save
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		
		
		/*Step 7: logout and close the browser
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(element).perform();
		
		driver.findElement(By.className("drop_down_usersettings")).click();*/
		driver.quit();

	}
}
