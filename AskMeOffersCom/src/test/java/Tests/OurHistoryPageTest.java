package Tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.TestBase;
import ExtentReports.CaptureScreenShot;
import Pages.AboutUsPage;
import Pages.HomePage;
import Pages.OurHistoryPage;

public class OurHistoryPageTest extends TestBase {

	HomePage homepage;
	AboutUsPage aboutus;
	OurHistoryPage ourhistory;
	
	public OurHistoryPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
	TestBase.initDriver();
	}
	
	@Test
	public void OurHistoryTest() throws InterruptedException {
		OurHistoryPage ohp = new OurHistoryPage(driver, test);
		logger = report.createTest("OurHistorylink");
		ohp.OurHistorylink();
		Thread.sleep(4000);
		ohp.OurHistoryText();
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
