package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateProductPage extends WebDriverUtility
{
	
	//Declaration
@FindBy(name="productname")
private WebElement PrdNameEdt;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

//Initialization

	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPrdNameEdt() {
		return PrdNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Business Library
	public void CreateProduct(String PrdName)
	{
		PrdNameEdt.sendKeys(PrdName);
		saveBtn.click();
	}
	
}
