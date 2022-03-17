package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Step 1: Declaration
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitBtn;
	
	//Step 2: Initalization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step 3: Utilization
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Business Library
	public void loginToApp(String userName, String password)
	{
		userNameEdt.sendKeys("admin");
		passwordEdt.sendKeys("admin");
		submitBtn.click();
	}
	
	
}
