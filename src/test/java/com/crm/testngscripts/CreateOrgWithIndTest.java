package com.crm.testngscripts;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;


public class CreateOrgWithIndTest extends BaseClass
 {
		@Test
		public void createOrgName() throws Throwable
		{
			
			
			//Read the data from all necessary file
			
			String OrgName = eLib.readDataFromExcel("Org", 4, 2)+" "+jLib.getRandomnumber();
			String indtype = eLib.readDataFromExcel("Org", 4, 3);
		
			
			/*Step 4: Navigate to Organizations Link*/
			HomePage hp=new HomePage(driver);
			hp.ClickOrgLink();
		
			OrganizationPage op=new OrganizationPage(driver);
			op.clickOnCreateOrgImg();
			
			
			/*Step 5: click on create orgnization btn*/
			CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName, indtype);
			
			//Step 6: Verification
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String actOrgName = oip.OrgNameInfo();
			if(actOrgName.contains(OrgName))
			{
				System.out.println(OrgName+"---> Data varified");
			}
			else
			{
				System.out.println(" Invalid Data ");
			}
		                                                                                                                                                                   
		}

	}
