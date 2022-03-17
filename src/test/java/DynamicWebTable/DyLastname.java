package DynamicWebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class DyLastname extends BaseClass
{
	@Test

	public void dynamic() throws Throwable

	{

	 /*Step : Navigate to Contact Link*/
			HomePage hp=new HomePage(driver);
			hp.ClickContactLink();
			
			List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]"));
			
			for(int i=0;i<=ele.size()-1;i++)
			{
				WebElement we = ele.get(i);
				String val = we.getText();
				System.out.println(val);
			}
				
	}
}
