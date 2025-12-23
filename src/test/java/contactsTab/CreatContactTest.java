package contactsTab;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import POMUtilities.ConInfoPomPage;
import POMUtilities.ConPompage;
import POMUtilities.CreateConPomPage;
import POMUtilities.HomePomPage;
import POMUtilities.LoginPomPage;
import Utility.ExcelFileUtility;
import Utility.JsonFileUtility;
import Utility.PropertyFileUtility;
import Utility.WebDriverUtilities;


public class CreatContactTest {
	@Test

	    public void createContactTest() throws IOException, ParseException {

	        WebDriverUtilities wutil = new WebDriverUtilities();
	        PropertyFileUtility putil = new PropertyFileUtility();
	        ExcelFileUtility eutil = new ExcelFileUtility();
	        JsonFileUtility jutil = new JsonFileUtility();

	        String browser = putil.fetchdatafrompropertyfile("browser");
	        String timeout = putil.fetchdatafrompropertyfile("timeouts");

	        String url = jutil.fetchDataFromJsonFile("url");
	        String username = jutil.fetchDataFromJsonFile("username");
	        String password = jutil.fetchDataFromJsonFile("password");

	        String lastname = eutil.fetchDataFromExcelFile("Contacts", 1, 1);

	        wutil.launchTheBroweser(browser);
	        wutil.MaximizeThebrowser();
	        wutil.ImplicitWait(timeout);
	        wutil.navigateToApplication(url);

	        LoginPomPage login = new LoginPomPage(wutil.driver);
	        login.login(username, password);

	        HomePomPage home = new HomePomPage(wutil.driver);
	        home.getContact_tab();

	        ConPompage conPage = new ConPompage(wutil.driver);
	        conPage.getPlusicon();

	        CreateConPomPage createCon = new CreateConPomPage(wutil.driver);
	        createCon.getConnameTF(lastname);
	        createCon.getSaveBtn();

	        ConInfoPomPage conInfo = new ConInfoPomPage(wutil.driver);
	        Assert.assertEquals(conInfo.getVerifyconname(), lastname);

	        Reporter.log("Contact created successfully", true);

	        home.logout(wutil);
	        wutil.QuitBrowser();
	        eutil.closeExcelFile();
	    }}