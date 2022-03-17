package DynamicWebTable;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class DySearchele extends BaseClass
{
@Test
public void dynamic()
{
	HomePage hp=new HomePage(driver);
	hp.ClickOrgLink();
	
	
	String orgName = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[6]/td[3]")).getText();
	wLib.select(driver.findElement(By.xpath("//select[@name='search_field']")), "Organization Name");
	driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgName);
	driver.findElement(By.xpath("//input[@name='submit']"));

	//wLib.switchToWindow(driver, "");
}
}
