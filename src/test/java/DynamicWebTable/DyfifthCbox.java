package DynamicWebTable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class DyfifthCbox extends BaseClass
{
	@Test
public void dynamic() throws Throwable
{
		HomePage hp=new HomePage(driver);
		hp.ClickContactLink();
	
	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[1]")).click();
	   driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[1]/following-sibling::td[9]/a[2]")).click();
	  wLib.acceptAlert(driver);
     
	}
}