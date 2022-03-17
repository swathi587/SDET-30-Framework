package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CampaignPage extends WebDriverUtility
{

	//Step 1: Declaration
	 @FindBy(xpath="//img[@alt='Create Campaign...']")
		private WebElement createCampLookUpImg;
		
		//Step2: Initialization
			public CampaignPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

			//Step 3: Utilization
			public WebElement getCreateLeadLookUpImg() {
				return createCampLookUpImg;
			}
			
			//Business Library
			public void ClickOnCreateCampLnk()
			{
				createCampLookUpImg.click();
			}
			
			
}
