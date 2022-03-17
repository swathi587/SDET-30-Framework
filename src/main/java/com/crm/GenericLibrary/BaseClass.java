package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class BaseClass 
{
	public DatabaseUtility dbLib=new DatabaseUtility();
	public JavaUtility jLib=new JavaUtility();
	public	PropertyFileUtility pLib=new PropertyFileUtility();
	public	ExcelUtility eLib=new ExcelUtility();
	public	WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver=null;
	
	  public static WebDriver sDriver;
	
	@BeforeSuite(groups={"smokeSuite","regressionSuite"})
	public void connectToDB()
	{
		//dbLib.connectToDb;
		Reporter.log("===Connect to Database===",true);
	}
	
	@BeforeClass(groups={"smokeSuite","regressionSuite"})
	//@Parameters("browser")
	//@BeforeTest
	//For Parallel Execution parameterized String BROWSER
	public void launchBrowser() throws Throwable 
	{
		//read the data from property
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		
		//CreateRuntim polymorphism
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
		
		sDriver = driver;
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		Reporter.log("===Browser launch successful===",true);
		
	}
	
	@BeforeMethod(groups={"smokeSuite","regressionSuite"})
	public void login() throws Throwable
	{
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME , PASSWORD);
		Reporter.log("===Login successful===",true);
	}
	
	@AfterMethod(groups={"smokeSuite","regressionSuite"})
	public void logout()
	{
		HomePage hp=new HomePage(driver);
		hp.SignOutOfApp(driver);
		Reporter.log("===Logout successful===",true);
	}
	
	
	//@AfterClass(groups={"smokeSuite","regressionSuite"})
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("===Browser close successful===",true);
	}
	@AfterSuite(groups={"smokeSuite","regressionSuite"})
	public void closeDB()
	{
		//dbLib.closeDB();
		Reporter.log("===close Database successful===",true);
	}
	
}
