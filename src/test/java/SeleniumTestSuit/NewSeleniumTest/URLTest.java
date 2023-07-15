package SeleniumTestSuit.NewSeleniumTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.PagesClass;
import utils.Utilities;
import utils.myDriverFactory;

/**
 * Unit test for simple App.
 */
public class URLTest {

	PagesClass pc = new PagesClass(myDriverFactory.getDriver());
	testBase tb = new testBase();
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static String screenshotPath;

	@BeforeMethod
	public void browserConfig() {
		tb.BrowserInitSetup();
	}

//	@AfterMethod
//	public void browserKill() {
//		tb.BrowserQuit();
//	}

	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Hamid System");
		extent.addSystemInfo("User Name", "Hamid Automation Labs");
		extent.addSystemInfo("Environment", "QA");
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
		myDriverFactory.getDriver().close();
	}

	@AfterSuite
	public void killChrome() {
		myDriverFactory.getDriver().quit();
	}

	@BeforeMethod
	public void setup() {
		myDriverFactory.getDriver();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, InterruptedException {
		screenshotPath = Utilities.getScreenshot(myDriverFactory.getDriver(), result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED Is: " + result.getName()); // to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED Is: " + result.getThrowable()); // to add error/exception
																								// in extent report

			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to add screenshot in extent
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED Is: " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED Is: " + result.getName());
			Thread.sleep(2222);
			extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath)); // to add screenshot in extent
																							// report

		}

		extent.endTest(extentTest); // ending test and ends the current test and prepare to create html report

	}

	@Test
	public void google() {
		extentTest = extent.startTest(new Throwable().getStackTrace()[0].getMethodName());
		pc.openGoogle();
		Assert.fail();
	}

	@Test
	public void inCom() {
		extentTest = extent.startTest(new Throwable().getStackTrace()[0].getMethodName());
		pc.openInDotCom();
	}

	@Test
	public void Yahoo() {
		extentTest = extent.startTest(new Throwable().getStackTrace()[0].getMethodName());
		pc.openYahoo();
	}

	@Test
	public void ToolsQA() {
		extentTest = extent.startTest(new Throwable().getStackTrace()[0].getMethodName());
		pc.openToolsQA();
	}

	@Test
	public void guru99() {
		extentTest = extent.startTest(new Throwable().getStackTrace()[0].getMethodName());
		pc.openGuru99demo();
	}
}
