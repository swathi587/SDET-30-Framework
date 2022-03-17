package CreateOpportunitiesTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOpportunitiesTest
{

@Test
	public void createOppotunitiesTest() throws Throwable
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
				
		//Create Contact name	
		 String Contact = eLib.readDataFromExcel("Opportunities", 1, 4)+" "+jLib.getRandomnumber();	
		String Campaign = eLib.readDataFromExcel("Opportunities", 1, 3)+" "+jLib.getRandomnumber();
		String OpportunitiesName = eLib.readDataFromExcel("Opportunities", 1, 0)+" "+jLib.getRandomnumber();
		String text=eLib.readDataFromExcel("Opportunities",1,1);
		String Lead=eLib.readDataFromExcel("Opportunities",1,2);
		
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
		

		//Step 4: Navigate to Contact Link
		driver.findElement(By.linkText("Contacts")).click();
		//Step 5: click on create contact btn
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 6: enter mandatory fields and save
		driver.findElement(By.name("lastname")).sendKeys(Contact);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Contact Verification
		String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header.contains(Contact))
		{
			System.out.println(Contact+" contact is created");
		}
		else
		{
			System.out.println("contact is not created");
		}
		//Step 7: Campaign
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();

		//wLib.switchToWindow(driver, "module=Home");
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(Campaign);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Campaign varification
		String headerCampaign = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerCampaign.contains(Campaign))
		{
				System.out.println(Campaign+" contact is created");
		}
		else
		{
				System.out.println("campaign is not created");
		}
		
		//Step 8 : Create Opportunites
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
	driver.findElement(By.name("potentialname")).sendKeys(OpportunitiesName);
		WebElement ele = driver.findElement(By.id("related_to_type"));
	    wLib.select(ele, text);
	   
	    
	    driver.findElement(By.xpath("//input[@name='related_to']/../img")).click();
	    wLib.switchToWindow(driver, "Contacts");
	    driver.findElement(By.name("search_text")).sendKeys(Contact);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(Contact)).click();
	    
		wLib.switchToWindow(driver, "Potentials");
		
		//Lead source Dropdown Handle
	    WebElement element=driver.findElement(By.name("leadsource"));
		wLib.select(element, 4);
		
		driver.findElement(By.xpath("//input[@name='campaignname']/../img")).click();
		wLib.switchToWindow(driver, "Campaigns&action=Popup&html");
		
		driver.findElement(By.id("search_txt")).sendKeys(Campaign);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(Campaign)).click();
		
	    
		wLib.switchToWindow(driver, "Potentials");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Opportunities 
		String headerOpportunity = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerOpportunity.contains(OpportunitiesName))
		{
				System.out.println(OpportunitiesName+" Opportunity is created");
		}
		else
		{
				System.out.println("Opportunity is not created");
		}
		
		//Logout
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, ele1);
		driver.findElement(By.linkText("Sign Out")).click();
		
       //driver.quit();		
}
}
