package contactsTab;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClassUtility.Baseclass;

import POMUtilities.ConInfoPomPage;
import POMUtilities.ConPompage;
import POMUtilities.CreateConPomPage;
import POMUtilities.CreateOrgPompage;
import POMUtilities.HomePomPage;
import POMUtilities.OrgInfoPompage;
import POMUtilities.OrgPompage;
import Utility.ExcelFileUtility;
import Utility.JavaUtility;
import Utility.JsonFileUtility;
import Utility.WebDriverUtilities;
@Listeners(Utility.ListernersUtility.class)
public class ContactScenariosTest  extends Baseclass{
//Push
   @Test(groups="smoke")
   public void createConTest()  throws IOException, InterruptedException {
	   
	   //Creating instances
	   JavaUtility jutil=new  JavaUtility();
	   ExcelFileUtility exutil=new ExcelFileUtility();
	   
	   //Get the random no.
	   int randomint=jutil.generateRandomNo();
	   
	   //Fetch data from excel utility
	   String conname=exutil.fetchDataFromExcelFile("contact",1,2) + randomint;
	   
	   HomePomPage home=new  HomePomPage(driver);
	   
	   //Validate homepage using soft assert
	   String acthomeheader=home.getHomeHeader();
	   SoftAssert soft=new SoftAssert();
	   soft.assertEquals(acthomeheader, "Home");
	   
	   //Identify contact tab and click on it
	   home.getContact_tab();
	   
	   //Identify plus icon and click on it
	   ConPompage con= new ConPompage(driver);
	   con.getPlusicon();
	   
	   //Identify lastname TF and enter cont came
	   CreateConPomPage createCon=new CreateConPomPage(driver);
	   createCon.getConnameTF(conname);
	   
	   //Identify save btn and click on it
	   createCon.getSaveBtn();
	   
	   //Validate contact name
	   ConInfoPomPage coninfo=new ConInfoPomPage(driver);
	   String verifyconname=coninfo.getVerifyconname();
	   
	   //Using hard assert and validating Contact name
	   Assert.assertTrue(verifyconname.contains(conname),"Verified contact name failed");
	   
	   //Identify contact tab and click on it
	   home.getContact_tab();
	   
	   //Identify delete link and click on it
	   driver.findElement(By.xpath(
			   "//a[text()='" + conname + "']/ancestor::tr//a[text()='del']"
			  )).click();
	   Thread.sleep(2000);
	   
	   //Handle alert popup
	   wutil.switchto_Alert(driver);
	   
	   //close
	   exutil.closeExcelFile();
	   
	  }
   
@Test(groups="reg")
public void ConwithOrgTest() {
	 //Creating instances
	   JavaUtility jutil=new  JavaUtility();
	   ExcelFileUtility exutil=new ExcelFileUtility();
	   WebDriverUtilities wutil=new WebDriverUtilities();
	   
	   //Get the random no.
	   int randomint=jutil.generateRandomNo();
	   
	   //Fetch data from excel utility
	   String conname=exutil.fetchDataFromExcelFile("contact",4,2) + randomint;
	   String orgname=exutil.fetchDataFromExcelFile("contact",4,3) + randomint;
	   
	   HomePomPage home=new  HomePomPage(driver);
	   
	   //Validate homepage using soft assert
	   String acthomeheader=home.getHomeHeader();
	   SoftAssert soft=new SoftAssert();
	   soft.assertEquals(acthomeheader, "Home");
	   
	   //Identify org tab and click on it
	   home.getOrg_tab();
	   
	   //Identify plus icon and click on it
	   OrgPompage org=new OrgPompage(driver);
	   org.getPlusicon();
	   
	   //Identify org TF and enter orgname
	   CreateOrgPompage createOrg=new CreateOrgPompage(driver);
	   createOrg.enterOrgName(orgname);
	   
	   //Identify save btn and click on it
	   createOrg.clickSave();
	   
	   //Validate org name
	   OrgInfoPompage orginfo=new OrgInfoPompage(driver);
	   
	   String verifyorg=orginfo.getVerifyorgname();
	   
	   //Using Hard Assert validate orgname
	   Assert.assertEquals(verifyorg, orgname, "Verified orgname failed");
	   
	   //Identify contact tab and click on it
	   home.getContact_tab();
	   
	   //Identify plus icon and click on it
	   ConPompage con= new ConPompage(driver);
	   con.getPlusicon();
	   
	// Identify lastname TF and enter contact name
	   CreateConPomPage createCon = new CreateConPomPage(driver);
	   createCon.enterLastName(conname);

	   // Select organization (window handling inside POM)
	   createCon.selectOrganization(orgname, wutil);

	   // Save contact
	   createCon.clickSave();

	   
	   //Fetch parent window id
	   String pwid = wutil.fetchTheParentWindowId(driver);
	   
	   //Switch the driver control to child window
	   wutil.switchtoWindowsUsingUrl(driver,"Accounts&action");
	   
	   //Search for org name
	   createCon.getConnameTF(orgname);
	   createCon.getSearchNowBtn();
	   driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();
	   //Switch back to parent window
	   wutil.swithbacktoParent(driver, pwid);
	   //Identify save btn and click on it
	   createCon.getSaveBtn();
	   
	   //Validate contact name
	   ConInfoPomPage coninfo=new ConInfoPomPage(driver);
	   String verifyconname=coninfo.getVerifyconname();
	   
	   //Using hard assert and validating Contact name
	   Assert.assertTrue(verifyconname.contains(conname),"Verified contact name failed");
	   
	   //Identify contact tab and click on it
	   home.getContact_tab();
	   
	   //Identify delete link and click on it
	   driver.findElement(By.xpath(
			   "//a[text()='" + conname + "']/ancestor::tr//a[text()='del']"
			  )).click();
	   Thread.sleep(2000);
	   
	   //Handle alert popup
	   wutil.switchto_Alert(driver);
	   
	   //Identify org tab and click on it
	   home.getOrg_tab();
	   
	   //Identify delete link and click on it
	   driver.findElement(By.xpath("//a[text()='" +conname + "']/ancestor::tr[@bgcolor='white']/descendant")).click();
	   
	   Thread.sleep(2000);
	   
	   //close
	   exutil.closeExcelFile();
	   soft.assertAll();
	  

//Handle alert popup
wutil.switchto_Alert(driver);
   
}

@Test(groups="reg")
public void conWithSuppDateTest() throws EncryptedDocumentException, IOException, InterruptedException {
	
	//Creating instances
	   JavaUtility jutil=new  JavaUtility();
	   ExcelFileUtility exutil=new ExcelFileUtility();
	   WebDriverUtilities wutil=new WebDriverUtilities();
	   
	   //Get the random no.
	   int randomint=jutil.generateRandomNo();
	   
	   //Fetch data from excel utility
	   String conname=exutil.fetchDataFromExcelFile("contact",7,2) + randomint;
	
 HomePomPage home=new  HomePomPage(driver);
	   
	   //Validate homepage using soft assert
	   String acthomeheader=home.getHomeHeader();
	   SoftAssert soft=new SoftAssert();
	   soft.assertEquals(acthomeheader, "Home");
	   
	   //Identify contact tab and click on it
	   home.getContact_tab();
	   
	   //Identify plus icon and click on it
	   ConPompage con= new ConPompage(driver);
	   con.getPlusicon();
	   
	   //Identify lastname TF and enter cont came
	   CreateConPomPage createCon=new CreateConPomPage(driver);
	   createCon.getConnameTF(conname);
	   
	   //Generate Todays date
	   String startdate=jutil.fetchTodaysDate();
	   Reporter.log(startdate,true);
	   
	   //Identify startdate TF and pass the text
	   createCon.getSuppStartdateTF(startdate);
	   
	   //Generate data after 30 days
	   String enddate=jutil.fetchDateAfterGivenDays(30);
	   Reporter.log(enddate,true);
	   
	   //Identify end date TF and pass the text
	   createCon.getSuppEnddateTF(enddate);
	   
	   //Identify save btn and click on it
	   createCon.getSaveBtn();
	   
	   //Validate contact name
	   ConInfoPomPage coninfo=new ConInfoPomPage(driver);
	   String verifyconname=coninfo.getVerifyconname();
	   
	   //Using hard assert and validating Contact name
	   Assert.assertTrue(verifyconname.contains(conname),"Verified contact name failed");
	   
	 //Validate startdate
	 String verifystartdate=coninfo.getVerifyStartDate(); 
	 
	//Using hard assert and validating Start date
	 Assert.assertTrue(verifystartdate.contains(startdate), "Verify support start date failed");
	 
	 //Validate end date
	 String Verifyenddate=coninfo.getVerifyEndDate();
	 
	 //Using hard assert
	 Assert.assertTrue(Verifyenddate.contains(Verifyenddate),"Verify support end date failed");
	 
	   //Identify contact tab and click on it
	   home.getContact_tab();
	   
	   //Identify delete link and click on it
	   driver.findElement(By.xpath(
			   "//a[text()='" + conname + "']/ancestor::tr//a[text()='del']"
			  )).click();
	   
	   
	   //Handle alert popup
	   wutil.switchto_Alert(driver);
	   
	  
	   
	   //close
	   exutil.closeExcelFile();
	   soft.assertAll();
	 	   
}   
	   
   
}





