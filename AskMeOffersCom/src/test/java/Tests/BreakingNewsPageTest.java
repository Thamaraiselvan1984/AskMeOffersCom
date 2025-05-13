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
import Pages.BreakingNewsPage;
import Pages.HomePage;
import Pages.OurHistoryPage;

public class BreakingNewsPageTest extends TestBase {
	
	HomePage homepage;
	AboutUsPage aboutus;
	OurHistoryPage ourhistory;
	BreakingNewsPage breakingnews;
	

	public BreakingNewsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		TestBase.initDriver();
	}
	
   @Test
   public void BreakingNewsTest() throws InterruptedException {
	   BreakingNewsPage bnp = new BreakingNewsPage(driver, test);
	   logger = report.createTest("BreakingNewslink");
	   bnp.BreakingNewslink();
	   Thread.sleep(4000);
	   bnp.BreakingNewsHeader();
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
