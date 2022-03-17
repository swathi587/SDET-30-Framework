package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadinfoPage 
{

	//Step 1: Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	//Step2: Initialization
			public LeadinfoPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

			// Step 3; Utilization
						public WebElement getHeaderText() {
							return headerText;
						}
				
						//Business library
						public String Leadinfo()
						{
							String Leadinfo = headerText.getText();
							return Leadinfo;
						}

						

						
				
	
}
