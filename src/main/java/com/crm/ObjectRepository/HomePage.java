package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage  extends WebDriverUtility 
{

	//Step 1: Declaration
  @FindBy(linkText="Organizations")
  private WebElement OrganizationLnk;
  
  @FindBy(linkText="Contacts")
  private WebElement ContactsLnk;
  
  @FindBy(linkText="Opportunities")
  private WebElement OpportunitiesLnk;
  
  @FindBy(linkText="Leads")
  private WebElement LeadLnk;
  
  
  @FindBy(linkText="Products")
  private WebElement ProductsLnk;
  
  @FindBy(linkText="More")
  private WebElement MoreLnk;
  
  @FindBy(linkText="Campaigns")
  private WebElement CampaignsLnk;
  
  @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
  private WebElement administratorImg;
  
  @FindBy(linkText="Sign Out")
  private WebElement SignOutLnk;
  
  //Step 2: Initialization
  public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step 3: Utilization
public WebElement getOrganizationLnk() {
	return OrganizationLnk;
}

public WebElement getContactsLnk() {
	return ContactsLnk;
}

public WebElement getOpportunitiesLnk() {
	return OpportunitiesLnk;
}

public WebElement getProductsLnk() {
	return ProductsLnk;
}

public WebElement getLeadLnk() {
	return LeadLnk;
}
public WebElement getMoreLnk() {
	return MoreLnk;
}

public WebElement getCampaignsLnk() {
	return CampaignsLnk;
}



public WebElement getAdministratorImg() {
	return administratorImg;
}

public WebElement getSignOutLnk() {
	return SignOutLnk;
}
  






//business Library
public void ClickOrgLink()
{
	OrganizationLnk.click();
	}
public void ClickMoreLink()
{
	MoreLnk.click();
	}
public void ClickProductLink()
{
	ProductsLnk.click();
}

public void ClickContactLink()
{
	ContactsLnk.click();
}
public void ClickLeadLink()
{
	LeadLnk.click();
}
public void ClickCampLink()
{
	CampaignsLnk.click();
}

public void SignOutOfApp(WebDriver driver)
{
	mouseHover(driver, administratorImg);
	SignOutLnk.click();
}
}
