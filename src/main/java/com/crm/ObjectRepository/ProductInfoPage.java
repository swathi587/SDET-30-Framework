package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ProductInfoPage extends WebDriverUtility
{
@FindBy(xpath="//span[@class='lvtHeaderText']")
private WebElement headerText;

//Step2: Initialization
		public ProductInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		// Step 3; Utilization
		public WebElement getHeaderText() {
			return headerText;
		}		
			
					//Business library
					public String ProductInfo()
					{
						String ProductInfo = headerText.getText();
						return ProductInfo;
					}

					
			
}
