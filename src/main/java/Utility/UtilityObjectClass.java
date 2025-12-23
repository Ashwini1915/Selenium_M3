package Utility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityObjectClass {
	
	public static ThreadLocal<ExtentTest> stest=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> sdriver=new ThreadLocal<WebDriver>();
	
	public static ExtentTest getSTest() {
		return stest.get();
	}
	
	public static void setStest(ExtentTest test) {
		stest.set(test);
	}
	
public static WebDriver getDriver() {
	return sdriver.get();
}
public static void setDriver(WebDriver driver) {
	sdriver.set(driver);
}
}
