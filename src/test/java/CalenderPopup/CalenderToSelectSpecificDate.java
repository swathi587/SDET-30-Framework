package CalenderPopup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CalenderToSelectSpecificDate {

	@Test
	public void calender()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10,10).click().perform();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	 String arrowXpath = "//span[@aria-label='Next Month']";
		String dateXpath = "//div[text()='April 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='12']";
		
		for(;;)
		{
			try{
		
		driver.findElement(By.xpath(dateXpath)).click();
		break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath(arrowXpath)).click();
			}
	
	}
	}
	}
