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
import Pages.HealthPage;

public class HealthPageTest extends TestBase {
	
	HealthPage page;
	

	public HealthPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		TestBase.initDriver();
	}
	
	@Test
	public void HealthTest() throws InterruptedException {
	HealthPage hp = new HealthPage(driver, test);
	logger = report.createTest("HealthTestLink");
	hp.HealthLink();
	Thread.sleep(4000);
	hp.HealthText();
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
