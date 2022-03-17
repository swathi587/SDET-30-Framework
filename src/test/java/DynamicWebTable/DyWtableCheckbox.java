package DynamicWebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;

public class DyWtableCheckbox extends BaseClass
{
@Test

public void dynamic() throws Throwable

{

 /*Step 4: Navigate to Contact Link*/
		HomePage hp=new HomePage(driver);
		hp.ClickContactLink();

	List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));

	for(WebElement e : ele)
	{
	    e.click();
	}
}


}

