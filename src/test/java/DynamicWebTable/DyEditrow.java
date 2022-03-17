package DynamicWebTable;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class DyEditrow extends BaseClass
{
@Test
public void dynamic()
{
	HomePage hp=new HomePage(driver);
	hp.ClickOrgLink();
	
	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[6]/td[1]")).click();
	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[6]/td[1]/following-sibling::td[7]/a[1]")).click();
	
	 wLib.switchToWindow(driver, "EditView&record=34&return_module");
	driver.findElement(By.xpath("//input[@name='website']")).clear();
	driver.findElement(By.xpath("//input[@name='website']")).sendKeys("http://www.google.com");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
   wLib.switchToWindow(driver, "action=index&module=Accounts&parenttab");
   //hp.SignOutOfApp(driver);
	
	
}
}
