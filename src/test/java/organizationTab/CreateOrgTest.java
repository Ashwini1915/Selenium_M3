package organizationTab;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//public class CreateOrgTest {
//	String browser="chrome";
//	String orgname = "job";
	//String phno="8456789512";
	//Launch the browser
	
	//WebDriver driver= new ChromeDriver();
	
//		if(browser.equals("chrome")) {
//			driver=new ChromeDriver();
//		}else if(browser.equals("edge")) {
//			driver=new EdgeDriver();
//		} else if(browser.equals("firefox")) {
//			driver=new FirefoxDriver();
//		} else {
//			driver=new ChromeDriver();
//		}
//		//Maximize the window
//		driver.manage().window().maximize();
//		//Implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		//Navigate to an application
//		driver.get("http://localhost:8888/");
//		//Identify login TF and pass the text
//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		//Identify password TF and pass the text
//		driver.findElement(By.name("user_password")).sendKeys("admin");
//		//Identify login button and click on it
//		driver.findElement(By.id("submitButton")).click();
//		//Identify contact tab and click on it
//		driver.findElement(By.linkText("Organizations")).click();
//		//Identify plus icon and click on it
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		//Identify org tf and enter orgname
//		driver.findElement(By.name("accountname")).sendKeys(orgname);
//		//identify save button and click on it
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		//Validate org name
//		WebElement verifyorg = driver.findElement(By.xpath("//span[Contains(text()")) ;
//				if(verifyorg.getText().contains(orgname)) {
//					System.out.println("Create org Test Pass");
//				}else {
//					System.out.println("Create org Test Fail");
//				}
		


