package Utility;



import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseclassUtility.BaseClass;



public class ListernersUtility implements ITestListener, ISuiteListener  {
	ExtentReports report;
	ExtentTest	test;
	@Override
	public void onStart(ISuite suite) {
		
		Reporter.log("Suite Exceution started- Adv Report configuration", true);
		String time=new Date().toString().replace(":", "_").replace(" ", "_");
		
		//Configuration of advance report
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReports/VtigerReport"+time+".html");
		spark.config().setDocumentTitle("VtigerContactAndOrgReports");
		spark.config().setReportName("Contact_Org");
		spark.config().setTheme(Theme.DARK);
		
		//Configuration test result
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS-Version", "window-11");
		report.setSystemInfo("Chrome Version", "Chrome-143");
		report.setSystemInfo("Edge Version", "Edge-143");
		report.setSystemInfo("FirefoxVersion", "Firefox-146");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("Suite Exceution finished-Adv Report Backup", true);
		UtilityObjectClass.getSTest().log(Status.INFO, "Suite Exceution finished-Adv Report Backup" );
		report.flush();
	}

	  @Override
	    public void onTestStart(ITestResult result) {
	        String testname = result.getMethod().getMethodName();

	        test = report.createTest(testname);
	        UtilityObjectClass.setStest(test);

	        Reporter.log(testname + " execution started", true);
	    }

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Reporter.log(testname + ": Test Exceution Success", true);
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    String testname = result.getMethod().getMethodName();
	    Reporter.log(testname + ": Test Execution Failed - Screenshot Taken", true);
	    String time=new Date().toString().replace(":","_" ).replace("", "_");

	    TakesScreenshot ts = (TakesScreenshot) UtilityObjectClass.getDriver();
	    String src = ts.getScreenshotAs(OutputType.BASE64);
	    test.addScreenCaptureFromBase64String(src, testname);

	    }


	@Override
	public void onTestSkipped(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Reporter.log(testname + ": Test Exceution Skipped", true);
	}


}
