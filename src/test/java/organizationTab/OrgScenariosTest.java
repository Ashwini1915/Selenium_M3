package organizationTab;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import POMUtilities.CreateOrgPompage;
import POMUtilities.HomePomPage;
import POMUtilities.LoginPomPage;
import POMUtilities.OrgInfoPompage;
import POMUtilities.OrgPompage;
import Utility.ExcelFileUtility;
import Utility.JavaUtility;
import Utility.PropertyFileUtility;
import Utility.WebDriverUtilities;

public class OrgScenariosTest {

    // 🔹 Scenario 1: Create Organization (Mandatory field only)
    @Test(groups = "regression")
    public void createOrganizationTest() throws EncryptedDocumentException, IOException {

        PropertyFileUtility putil = new PropertyFileUtility();
        ExcelFileUtility eutil = new ExcelFileUtility();
        JavaUtility jutil = new JavaUtility();
        WebDriverUtilities wutil = new WebDriverUtilities();

        String browser = putil.fetchdatafrompropertyfile("browser");
        String url = putil.fetchdatafrompropertyfile("url");
        String username = putil.fetchdatafrompropertyfile("username");
        String password = putil.fetchdatafrompropertyfile("password");
        String timeouts = putil.fetchdatafrompropertyfile("timeouts");

        String orgName = eutil.fetchDataFromExcelFile("organization", 1, 2)
                + jutil.generateRandomNo();

//        wutil.launchTheBroweser(browser);
//        wutil.MaximizeThebrowser();
//        wutil.ImplicitWait(timeouts);
//        wutil.navigateToApplication(url);

//        LoginPomPage login = new LoginPomPage(wutil.driver);
//        HomePomPage home = new HomePomPage(wutil.driver);

//        login.login(username, password);
//        home.getOrg_tab();
//
//        OrgPompage orgPage = new OrgPompage(wutil.driver);
//        orgPage.getPlusicon();
//
//        CreateOrgPompage createOrg = new CreateOrgPompage(wutil.driver);
//        createOrg.enterOrgName(orgName);
//        createOrg.clickSave();
//
//        OrgInfoPompage info = new OrgInfoPompage(wutil.driver);
//        Assert.assertTrue(info.getVerifyorgname().contains(orgName));
//        Reporter.log("Organization created successfully", true);
//
//        home.getOrg_tab();
//        wutil.driver.findElement(By.xpath(
//                "//a[text()='" + orgName + "']/../../descendant::a[text()='del']")).click();
//        wutil.switchto_Alert();
//
//        home.logout(wutil);
//        wutil.QuitBrowser();
//    }

    // 🔹 Scenario 2: Create Organization with Industry & Type
    @Test(groups = "smoke")
    public void createOrgWithIndustryAndTypeTest() throws IOException {

        PropertyFileUtility putil = new PropertyFileUtility();
        ExcelFileUtility eutil = new ExcelFileUtility();
        JavaUtility jutil = new JavaUtility();
        WebDriverUtilities wutil = new WebDriverUtilities();

        String browser = putil.fetchdatafrompropertyfile("browser");
        String url = putil.fetchdatafrompropertyfile("url");
        String username = putil.fetchdatafrompropertyfile("username");
        String password = putil.fetchdatafrompropertyfile("password");
        String timeouts = putil.fetchdatafrompropertyfile("timeouts");

        String orgName = eutil.fetchDataFromExcelFile("organization", 4, 2)
                + jutil.generateRandomNo();
        String industry = eutil.fetchDataFromExcelFile("organization", 4, 3);
        String type = eutil.fetchDataFromExcelFile("organization", 4, 4);

        wutil.launchTheBroweser(browser);
        wutil.MaximizeThebrowser();
        wutil.ImplicitWait(timeouts);
        wutil.navigateToApplication(url);

        LoginPomPage login = new LoginPomPage(wutil.driver);
        HomePomPage home = new HomePomPage(wutil.driver);

        login.login(username, password);
        home.getOrg_tab();

        OrgPompage orgPage = new OrgPompage(wutil.driver);
        orgPage.getPlusicon();

        CreateOrgPompage createOrg = new CreateOrgPompage(wutil.driver);
        createOrg.enterOrgName(orgName);

        WebElement industryDD = createOrg.getIndustryDD();
        wutil.selectDDByValue(industryDD, industry);

        WebElement typeDD = createOrg.getTypeDD();
        wutil.selectDDByValue(typeDD, type);

        createOrg.clickSave();

        OrgInfoPompage info = new OrgInfoPompage(wutil.driver);
        Assert.assertTrue(info.getVerifyorgname().contains(orgName));
        Assert.assertTrue(info.getVerifyindustry().contains(industry));
        Assert.assertTrue(info.getVerifytype().contains(type));

        Reporter.log("Organization created with Industry & Type", true);

        home.getOrg_tab();
        wutil.driver.findElement(By.xpath(
                "//a[text()='" + orgName + "']/../../descendant::a[text()='del']")).click();
        wutil.switchto_Alert();

        home.logout(wutil);
        wutil.QuitBrowser();
    }

    // 🔹 Scenario 3: Create Organization with Phone Number
    @Test(groups = "smoke")
    public void createOrgWithPhoneNumberTest() throws IOException {

        PropertyFileUtility putil = new PropertyFileUtility();
        ExcelFileUtility eutil = new ExcelFileUtility();
        JavaUtility jutil = new JavaUtility();
        WebDriverUtilities wutil = new WebDriverUtilities();

        String browser = putil.fetchdatafrompropertyfile("browser");
        String url = putil.fetchdatafrompropertyfile("url");
        String username = putil.fetchdatafrompropertyfile("username");
        String password = putil.fetchdatafrompropertyfile("password");
        String timeouts = putil.fetchdatafrompropertyfile("timeouts");

        String orgName = eutil.fetchDataFromExcelFile("organization", 7, 2)
                + jutil.generateRandomNo();
        String phone = eutil.fetchDataFromExcelFile("organization", 7, 3);

        wutil.launchTheBroweser(browser);
        wutil.MaximizeThebrowser();
        wutil.ImplicitWait(timeouts);
        wutil.navigateToApplication(url);

        LoginPomPage login = new LoginPomPage(wutil.driver);
        HomePomPage home = new HomePomPage(wutil.driver);

        login.login(username, password);
        home.getOrg_tab();

        OrgPompage orgPage = new OrgPompage(wutil.driver);
        orgPage.getPlusicon();

        CreateOrgPompage createOrg = new CreateOrgPompage(wutil.driver);
        createOrg.enterOrgName(orgName);
        createOrg.enterPhone(phone);
        createOrg.clickSave();

        OrgInfoPompage info = new OrgInfoPompage(wutil.driver);
        Assert.assertTrue(info.getVerifyorgname().contains(orgName));
        Assert.assertTrue(info.getVerifyphno().contains(phone));

        Reporter.log("Organization created with phone number", true);

        home.getOrg_tab();
        wutil.driver.findElement(By.xpath(
                "//a[text()='" + orgName + "']/../../descendant::a[text()='del']")).click();
        wutil.switchto_Alert();

        home.logout(wutil);
        wutil.QuitBrowser();
    }
}
