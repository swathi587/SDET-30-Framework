package CalenderPopup;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CalenderwithCurrentDate
{

@Test
public void calender()
{

	//Creating object for Date
	Date date=new Date();
   String actdate = date.toString();
	System.out.println(actdate);

	String[] date1 = actdate.split(" ");
	
	String day = date1[0];
    String mon = date1[1];
    String dat = date1[2];
    String year = date1[5];
    
    
    String DateFormat = day+" "+mon+" "+dat+" "+year;
   System.out.println(DateFormat);
   
  
   //Actual script
   WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");
	
	Actions actions=new Actions(driver);
	actions.moveByOffset(10,10).click().perform();
	
	driver.findElement(By.xpath("//span[text()='From']")).click();
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru");
	driver.findElement(By.xpath("//p[text()='Bengaluru International Airport']")).click();
	
	driver.findElement(By.xpath("//span[text()='To']")).click();
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Mumbai");
	driver.findElement(By.xpath("//p[text()='Chhatrapati Shivaji International Airport']")).click();
	
	//driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	driver.findElement(By.xpath("//div[@aria-label='"+DateFormat+"']")).click();
	//driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today']")).click();
	//driver.findElement(By.xpath(dateXpath)).click();
	
	driver.findElement(By.xpath("//a[text()='Search']")).click();
	driver.findElement(By.xpath("//span[text()='View Prices']")).click();
	driver.findElement(By.xpath("//button[text()='Book Now']")).click();
}
}

////button[text()='Book Now']/ancestor::div[@class='viewFareRowWrap']===for price
