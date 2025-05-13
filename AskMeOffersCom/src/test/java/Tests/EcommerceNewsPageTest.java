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
import Pages.EcommerceNewsPage;

public class EcommerceNewsPageTest extends TestBase {
	
	EcommerceNewsPageTest ecommercenewspage;

	public EcommerceNewsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
	TestBase.initDriver();
	}
	
	@Test
	public void EcommerceNewsTest() throws InterruptedException {
	EcommerceNewsPage enp = new EcommerceNewsPage(driver, test);
	logger = report.createTest("EcommerceNewsLink");
	enp.EcommerceNewsPagelink();
	Thread.sleep(4000);
	enp.EcommerceHeaderText();
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

