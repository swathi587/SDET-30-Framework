package DynamicWebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class DyWtLastcbox extends BaseClass
{
	@Test

	public void dynamic() throws Throwable

	{
       HomePage hp=new HomePage(driver);
			hp.ClickContactLink();
			
			 List<WebElement> ele=  driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]"));
	  
	       // System.out.println(ele.size());
  	
	   for (int i=ele.size()-1;i>=0;i--)
	        {
		   
		   
		      WebElement we = ele.get(i);
	      
	    		wLib.scrollAction(driver);
		         we.click();
	            break;
		   
    }
	  
	 
}
}