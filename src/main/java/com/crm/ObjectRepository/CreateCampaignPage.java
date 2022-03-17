package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateCampaignPage  extends WebDriverUtility{

	//Step 1: Declaration
		@FindBy(name="campaignname")
		private WebElement CampNameEdt;
		
		/*@FindBy(name="assigned_user_id")
		private WebElement assignedDropDown;
		*/
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		//Step2: Initialization
				public  CreateCampaignPage(WebDriver driver)
				{
					PageFactory.initElements(driver, this);
				}

				//Utilization
				public WebElement getCampNameEdt() {
					return CampNameEdt;
				}

				/*public WebElement getAssignedDropDown() {
					return assignedDropDown;
				}*/
				
		
	public WebElement getSaveBtn() {
					return saveBtn;
				}

				//Business Library
				public void CreateCampaignName(String CampName)
				{
					CampNameEdt.sendKeys(CampName);
					//select(assignTo, assignedDropDown);
					saveBtn.click();
					
				}
	
}
