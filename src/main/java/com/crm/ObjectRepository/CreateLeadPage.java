package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateLeadPage extends WebDriverUtility
{
	//Step 1: Declaration
		@FindBy(name="lastname")
		private WebElement LastNameEdt;
		
		@FindBy(name="company")
		private WebElement CompanyNameEdt;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		//Step2: Initialization
				public CreateLeadPage(WebDriver driver)
				{
					PageFactory.initElements(driver, this);
				}


				//Step 3: Utilization
				public WebElement getLastNameEdt() {
					return LastNameEdt;
				}

				public WebElement getCompanyNameEdt() {
					return CompanyNameEdt;
				}

				public WebElement getSaveBtn() {
					return saveBtn;
				}
				
				//Business Library
				public void createNewLead(String LastName, String CompanyName)
				{
					LastNameEdt.sendKeys(LastName);
					CompanyNameEdt.sendKeys(CompanyName);
					saveBtn.click();
				}
		
}
