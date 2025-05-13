package Tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.model.ReportStats;

import Base.TestBase;
import ExtentReports.CaptureScreenShot;
import ExtentReports.ExtentReportListener;
import Pages.AboutUsPage;
import Pages.HomePage;
import Pages.OurHistoryPage;

public class AboutUsPageTest extends TestBase {

	HomePage homepage;
	AboutUsPage aboutus;
	OurHistoryPage ourhistory;
	ExtentTest test;
	
	public AboutUsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
	TestBase.initDriver();
	}
	
	@Test
	public void AboutUsTest() throws InterruptedException {
		AboutUsPage abp = new AboutUsPage(driver, test);
		logger = report.createTest("AboutUsTestLink");
		abp.AboutUsLink();
		Thread.sleep(4000);
		abp.AboutUsText();
	}
	
	@AfterTest
	public void endReport() {
	report.flush();
	
	}
	
	@AfterMethod
	public void TestResult(ITestResult result) throws IOException, InterruptedException {
		setTestResult(result);
		takeScreenShotOnFailure();
		tearDown();
	}
	
}