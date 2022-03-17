package DynamicWebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class DyOrgRev extends BaseClass
{
@Test
public void dynamic()
{
	HomePage hp=new HomePage(driver);
	hp.ClickOrgLink();
	  List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));	
             
        for(int i=ele.size()-1;i>=0;i--)
        {
        	WebElement we = ele.get(i);
        	we.click();
        	
        }
}
}
