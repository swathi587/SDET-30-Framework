package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class POMPractice 
{
@Test
public void pomPratice()
{
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
	
	LoginPage lp=new LoginPage(driver);
	/*lp.getUserNameEdt().sendKeys("admin");
	lp.getPasswordEdt().sendKeys("admin");
	lp.getSubmitBtn().click();
	*/
	lp.loginToApp("admin", "admin");
	
	HomePage hp=new HomePage(driver);
	/*hp.getOrganizationLnk().click();
	hp.getSignOutLnk();
	*/
	hp.ClickOrgLink();
	hp.SignOutOfApp(driver);

}
}
