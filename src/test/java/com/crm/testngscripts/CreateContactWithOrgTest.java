
package com.crm.testngscripts;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateContactWithOrgTest extends BaseClass
{
	@Test(groups="smokeSuite")
	public void createContactWithOrg() throws Throwable
	{
	String Last_Name = eLib.readDataFromExcel("Contact", 4, 1)+" "+jLib.getRandomnumber();	
    String OrgName=eLib.readDataFromExcel("Contact",4, 3)+" "+jLib.getRandomnumber();
    
    /*Step 4: Navigate to Contact Link*/
  		HomePage hp=new HomePage(driver);
  		hp.ClickOrgLink();
  		
  		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		
		CreateOrganizationPage cop=new  CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName);
		
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
			      
				hp.ClickContactLink();
				
				ContactPage cp=new ContactPage(driver);
				cp.clickOnCreateContactImg();
				
				/*Step 5: click on create contact btn*/
				CreateContactPage ccp=new CreateContactPage(driver);
				ccp.createNewContact(driver, Last_Name, OrgName);
				
				//Step 6: Verification
				ContactInfoPage cip=new ContactInfoPage(driver);
				
				String actContactName = cip.ContactInfo();
				if(actContactName.contains(Last_Name))
				{
					System.out.println(Last_Name+"---> Data varified");
				}
				else
				{
					System.out.println(" Invalid Data ");
				}
			   
}
}