package organizationTab;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import POMUtilities.OrgInfoPompage;
import POMUtilities.OrgPompage;
import Utility.WebDriverUtilities;

public class CreateOrgwithIndustryAndTypeTest {
	@Test
	public void OrgwithIndusandType() {
		String browser="chrome";
		String orgname = "job";
		String conname="abcd1";
		//Launch the browser
		WebDriverUtilities driver=new WebDriverUtilities();
			WebDriver driver1=null;
			if(browser.equals("chrome")) {
				driver1=new ChromeDriver();
			}else if(browser.equals("edge")) {
				driver1=new EdgeDriver();
			} else if(browser.equals("firefox")) {
				driver1=new FirefoxDriver();
			} else {
				driver1=new ChromeDriver();
			}
			//Maximize the window
			driver1.manage().window().maximize();
			//Implicit wait
			driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//Navigate to an application
			driver1.get("http://localhost:8888/");
			//Identify login TF and pass the text
			driver1.findElement(By.name("user_name")).sendKeys("admin");
			//Identify password TF and pass the text
			driver1.findElement(By.name("user_password")).sendKeys("admin");
			//Identify login button and click on it
			driver1.findElement(By.id("submitButton")).click();
			//Identify org tab and click on it
			//driver.findElement(By.linkText("Organizations")).click();
			OrgPompage orgName=new OrgPompage(driver1);
			//Identify plus icon and click on it
			driver1.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			//Identify org tf and enter orgname
			driver1.findElement(By.name("accountname")).sendKeys(orgname);
			
			
			
			
			//identify save button and click
			driver1.findElement(By.xpath("//input[@type='button']")).click();
			
			//Verify the  orgname name
			//WebElement verifyname=driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]"));
//			OrgInfoPompage orginfo=new OrgInfoPompage(driver);
//			String verifyname=orginfo.getVerifyorgname();
//			if(verifyname.contains(orgname)) {
//				System.out.println("test pass");
//			}
//			else {
//				System.out.println("test fail");
//			}
			
		}
			

}
