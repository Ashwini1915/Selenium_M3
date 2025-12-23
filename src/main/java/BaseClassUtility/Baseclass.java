package BaseClassUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POMUtilities.HomePomPage;
import POMUtilities.LoginPomPage;
import Utility.DatabaseUtility;
import Utility.ExcelFileUtility;
import Utility.PropertyFileUtility;
import Utility.UtilityObjectClass;
import Utility.WebDriverUtilities;

public class Baseclass {
	
	public DatabaseUtility dutil=new DatabaseUtility();
	public WebDriverUtilities wutil=new WebDriverUtilities();
	public PropertyFileUtility putil= new PropertyFileUtility();
	public ExcelFileUtility eutil=new ExcelFileUtility();
	public WebDriver driver=null;
	
	
	public static WebDriver sdriver=null;
	
	@BeforeSuite
	public void connectToDatabse() throws SQLException {
	Reporter.log("Get connection with databse", true);
	dutil.connectToDatabase();
}

	@BeforeTest
	public void configParallelExcel() {
		Reporter.log("Configuration of parallel exceution", true);	
	}
	@BeforeClass
	@Parameters("browser")
	public void launchTheBrowser(String browser) throws IOException {

	    if (browser.equals("chrome")) {
	        driver = new ChromeDriver();
	    } else if (browser.equals("edge")) {
	        driver = new EdgeDriver();
	    } else if (browser.equals("firefox")) {
	        driver = new FirefoxDriver();
	    } else {
	        driver = new ChromeDriver();
	    }

	    sdriver = driver;
	    UtilityObjectClass.setDriver(driver); // ✅ FIX
	}

	

	@BeforeMethod
	public void login() throws IOException {
		String url = putil.fetchdatafrompropertyfile("url");
        String username = putil.fetchdatafrompropertyfile("username");
        String password = putil.fetchdatafrompropertyfile("password");
        String timeouts = putil.fetchdatafrompropertyfile("timeouts");
	        
	        wutil.MaximizeThebrowser(driver);
	        wutil.ImplicitWait(driver,timeouts);
	        wutil.navigateToApplication(driver,url);
	        Reporter.log("Login to the application", true); 
	        
	        LoginPomPage l=new LoginPomPage(driver);
	        l.login(username, password);
	}
	

	
	@AfterMethod
	public void logout() {
	    HomePomPage home = new HomePomPage(driver);
	    Reporter.log("Logout from the application", true);

	    wutil.UsingMousehover(driver, home.getAdministrator());
	    home.getSignout().click();
	}

	
	@AfterClass
	public void qutiTheBrowser() {
		 Reporter.log("Quit the application", true); 
		 wutil.QuitBrowser(driver);
	
	}
	@AfterTest
	public void closeParallelExe() {
		Reporter.log("Close Parallel Execution", true);	
	}
	
	@AfterSuite
	public void disconnectToDatabse() throws SQLException {
		Reporter.log("Disconnect with databse", true);
		dutil.closeDatabaseConnection();
}}
