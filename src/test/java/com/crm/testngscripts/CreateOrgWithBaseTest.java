package com.crm.testngscripts;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrgWithBaseTest extends BaseClass
{
@Test
public void createOrgTest() throws Throwable
{
	String OrgName = eLib.readDataFromExcel("Org", 1, 2)+" "+jLib.getRandomnumber();
	
	//Navigate to Organization link
	HomePage hp=new HomePage(driver);
	hp.ClickOrgLink();
	
	//Click Click on Organization btn
	OrganizationPage op=new OrganizationPage(driver);
	op.clickOnCreateOrgImg();
	
	//click on create orgnization btn*/
	CreateOrganizationPage cop=new CreateOrganizationPage(driver);
cop.createNewOrg(OrgName);

//Validation
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
