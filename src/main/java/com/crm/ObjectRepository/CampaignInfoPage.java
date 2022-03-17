package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {

	//Step 1: Declaration
			@FindBy(xpath="//span[@class='dvHeaderText']")
			private WebElement headerText;
			

			//Step2: Initialization
			public CampaignInfoPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

			//Step 3: Utilization
			public WebElement getHeaderText() {
				return headerText;
			}
			
			//Business library
			public String CampaignInfoPage()
			{
				String CampaignInfoPage = headerText.getText();
				return CampaignInfoPage;
			}
}
