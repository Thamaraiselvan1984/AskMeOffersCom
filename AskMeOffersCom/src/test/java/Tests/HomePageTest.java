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
import com.aventstack.extentreports.model.ReportStats;

import Base.TestBase;
import ExtentReports.CaptureScreenShot;
import ExtentReports.ExtentReportListener;
import Pages.AboutUsPage;
import Pages.HomePage;

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	AboutUsPage aboutus;
	ExtentTest test;
	
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
	TestBase.initDriver();
	
	}
	
	@Test
	public void HomeTest() throws InterruptedException {
		HomePage hp = new HomePage(driver, test);
		logger = report.createTest("HomePageLink");
		hp.HomePageLink();
		hp.askmeofferslink();
		hp.googlebox();
		Thread.sleep(4000);
		aboutus = hp.returnlink();
		}
	
	@AfterTest
	public void endReport() {
	report.flush();
	tearDown();
	}
	
	@AfterMethod
	public void TestResult(ITestResult result) throws IOException, InterruptedException {
		setTestResult(result);
		takeScreenShotOnFailure();
		tearDown();
	}
}

