package DynamicWebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class DynamicOddRowSel extends BaseClass
{

@Test
public void dynamic()
{
	HomePage hp=new HomePage(driver);
	hp.ClickOrgLink();
	  List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));	
             
	 System.out.println(ele.size());
        for(int i=0;i<=ele.size()-1;i++)
        {
        	if(i%2==0)
        	{
       ele.get(i).click();
        	}
        }
}
}
