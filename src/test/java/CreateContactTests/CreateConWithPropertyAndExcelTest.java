package CreateContactTests;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateConWithPropertyAndExcelTest {
@Test
public void createConWithPropertyAndExcelTest() throws Throwable
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
	Sheet sh = wb.getSheet("Contact");
	Row ro = sh.getRow(1);
	Cell cel = ro.getCell(1);
	String Last_Name = cel.getStringCellValue();
	
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
	

	/*Step 4: Navigate to Organizations Link*/
	driver.findElement(By.linkText("Contacts")).click();
	/*Step 5: click on create org swanization btn*/
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
	/*Step 6: enter mandatory fields and save*/
	driver.findElement(By.name("lastname")).sendKeys(Last_Name+" "+random);
	
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
	WebElement ele = driver.findElement(By.name("search_field"));
	Select s=new Select(ele);
//	List<WebElement> options = s.getOptions();
	s.selectByVisibleText("Website");
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	Thread.sleep(3000);
	
	
	driver.quit();
	
}
	
}
