package ExtentReports;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;


public class ExtentReportListener  {
	
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	
	
    public static void setTestResult(Method m, ITestResult result) throws IOException {
		
		String screenShot = CaptureScreenShot.captureScreen(driver, CaptureScreenShot.generateFileName(result));
		
		if(result.getStatus() == ITestResult.SUCCESS) {
		    test.pass(m.getName());
			test.pass("Screenshot: " + test.addScreenCaptureFromPath(screenShot));
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			test.fail(m.getName());
			test.fail(result.getThrowable());
			test.fail("Screenshot: " + test.addScreenCaptureFromPath(screenShot));
		}else if(result.getStatus() == ITestResult.SKIP) {
			test.skip("TestCase : " + m.getName() + " has been skipped");
		}
	}
}


