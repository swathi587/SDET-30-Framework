package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class LeadPage extends WebDriverUtility
{
//Step 1: Declaration
	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement createLeadLookUpImg;
	
	//Step2: Initialization
		public LeadPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Step 3: Utilization
		public WebElement getCreateLeadLookUpImg() {
			return createLeadLookUpImg;
		}
		
		//Business Library
		public void clickOnCreateLeadImg()
		{
			createLeadLookUpImg.click();
		}

}
