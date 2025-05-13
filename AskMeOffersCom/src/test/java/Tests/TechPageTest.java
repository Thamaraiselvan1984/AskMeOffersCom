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
import Pages.TechPage;

public class TechPageTest extends TestBase {
	
	TechPage techpage;
	
	public TechPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
	TestBase.initDriver();
	}
	
	@Test
	public void TechTest() throws InterruptedException {
	TechPage tp = new TechPage(driver, test);
	logger = report.createTest("TechTestlink");
	tp.Techlink();
	Thread.sleep(4000);
	tp.TechHeader();
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
