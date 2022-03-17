package POMScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductPage;

public class CreateProduct
{
@Test

public void createProduct() throws Throwable
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
	
	String PrdName = eLib.readDataFromExcel("Product", 1, 1)+" "+jLib.getRandomnumber();	
    //String OrgName=eLib.readDataFromExcel("Product",4, 3)+" "+jLib.getRandomnumber();
	 
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
		hp.ClickProductLink();
		
		ProductPage pp=new ProductPage(driver);
		pp.ClickOnCreateProLnk();
		
		CreateProductPage cop=new CreateProductPage(driver);
		cop.CreateProduct(PrdName);
		
		ProductInfoPage pip=new ProductInfoPage(driver);
		String actPrdName =pip.ProductInfo();
		
		
		if(actPrdName.contains(PrdName))
		{
			System.out.println(PrdName+"---> Data varified");
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
