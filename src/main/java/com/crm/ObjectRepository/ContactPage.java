package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactPage extends WebDriverUtility
{
	
	//Step 1: Declaration
		@FindBy(xpath="//img[@alt='Create Contact...']")
		private WebElement createContactImg;
		
		//Step2: Initialization
		public ContactPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Step 3: Utilization
		public WebElement getCreateContactImg() {
			return createContactImg;
		}

		//Business Library
		public void clickOnCreateContactImg()
		{
			createContactImg.click();
		}
}