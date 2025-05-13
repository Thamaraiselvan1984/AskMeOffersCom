package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import ExtentReports.ExtentReportManager;
import ExtentReports.CaptureScreenShot;
import ExtentReports.DateUtils;


public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	public static ExtentTest test;
	
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream io = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
			prop.load(io);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initDriver() {
	String browerName = prop.getProperty("browser");
	if(browerName.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\selenium\\Chrome131\\chromedriver-win64\\chromedriver.exe");
	driver = new ChromeDriver();
	}else if (browerName.equalsIgnoreCase("edge")) {
	System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Downloads\\selenium\\edge\\edgedriver_win64\\msedgedriver.exe");
	driver = new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	}
	
	public static void tearDown() {
		driver.quit();
	}
	
	public void takeScreenShotOnFailure() {

		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;

		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "//Screenshot//" + DateUtils.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(System.getProperty("user.dir") + "//Screenshot//" + DateUtils.getTimeStamp() + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setTestResult(ITestResult result) throws IOException, InterruptedException {
		
		String screenShot = CaptureScreenShot.captureScreen(driver, CaptureScreenShot.generateFileName(result));
	
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.fail(result.getName());
			logger.fail(result.getThrowable());
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.pass(result.getName());
		}else if(result.getStatus() == ITestResult.SKIP) {
			logger.skip("TestCase : " + result.getName() + " has been skipped");
		}
		logger.assignCategory(result.getMethod().getMethodName());
	}
	
	
}
