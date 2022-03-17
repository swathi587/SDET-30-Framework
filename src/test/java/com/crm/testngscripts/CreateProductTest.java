package com.crm.testngscripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductPage;

@Listeners(com.crm.GenericLibrary.ListenersImplementationClass.class)
public class CreateProductTest extends BaseClass
{

	@Test(groups="regressionSuite")
	public void createProduct() throws Throwable
	{
		String PrdName = eLib.readDataFromExcel("Product", 1, 1)+" "+jLib.getRandomnumber();
		
		/*Step 4: Navigate to Contact Link*/
		SoftAssert sa=new SoftAssert();
		HomePage hp=new HomePage(driver);
		hp.ClickProductLink();
		
		//For assertion
		String expdata="Products";
		String actdata = driver.findElement(By.linkText("Products")).getText();
		
		ProductPage pp=new ProductPage(driver);
		pp.ClickOnCreateProLnk();
		
		
		//Assertion 
		String expHeader = "Creating New product";
		String actHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		sa.assertEquals(actHeader, actHeader);
		
		//Creating Product
		CreateProductPage cop=new CreateProductPage(driver);
		cop.CreateProduct(PrdName);
		
		ProductInfoPage pip=new ProductInfoPage(driver);
		String actPrdName =pip.ProductInfo();
		//Assert.fail();
		
		
		/*if(actPrdName.contains(PrdName))
		{
			System.out.println(PrdName+"---> Data varified");
		}
		else
		{
			System.out.println(" Invalid Data ");
		}*/
	      
		Reporter.log(actPrdName+"Product Created",true);
		
		sa.assertTrue(actPrdName.contains("abc"));
		sa.assertAll();
		
	}
}
