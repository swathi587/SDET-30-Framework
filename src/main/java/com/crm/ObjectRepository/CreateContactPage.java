package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility
{

	//Step 1: Declaration
	@FindBy(name="lastname")
	private WebElement ConNameEdt;
	
    @FindBy(xpath="//input[@name='account_name']/following-sibling::img")
    private WebElement OrgNameLookUpImg;
    
    @FindBy(name="leadsource")
    private WebElement leadsourceDropDown; 
    
    @FindBy(name="search_text")
    private WebElement searchEdt;
    
    @FindBy(name="search")
    private WebElement searchBtn;
	
	

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Step2: Initialization
		public CreateContactPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//Step3: Utilization
		public WebElement getConNameEdt() {
			return ConNameEdt;
		}

		public WebElement getOrgNameLookUpImg() {
			return OrgNameLookUpImg;
		}
		public WebElement getLeadsourceDropDown() {
			return leadsourceDropDown;
		}
		public WebElement getSearchEdt() {
			return searchEdt;
		}
		public WebElement getSearchBtn() {
			return searchBtn;
		}
		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		//Business Library
		public void createNewContact(String lastName)
		{
			ConNameEdt.sendKeys(lastName);
			saveBtn.click();
		}
		
		public void createNewContact(String lastName,String leadSource)
		{
			ConNameEdt.sendKeys(lastName);
			select(leadSource, leadsourceDropDown);
			saveBtn.click();
		}
		
		public void createNewContact(WebDriver driver,String lastName,String OrgName)
		{
			ConNameEdt.sendKeys(lastName);
			 OrgNameLookUpImg.click();
			 switchToWindow(driver, "Accounts");
			 searchEdt.sendKeys(OrgName);
			 searchBtn.click();
			 driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
			 switchToWindow(driver, "Contacts");
			 saveBtn.click();
			
		}
		
}
