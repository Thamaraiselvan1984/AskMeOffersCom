package BaseTest;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.TestRailManager.TestRailManager;

public class basetest {
	String ScreenshotSubFolderName;
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extentReports;
	public static ExtentTest ExtentTest;
	public static String testCaseID;

	@Parameters("browser")
	@BeforeTest
	public void setup(ITestContext context, @Optional("chrome") String browserName) {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
			System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Admin\\Downloads\\selenium\\Chrome135\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\Admin\\Downloads\\selenium\\Edge126\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		String device = capabilities.getBrowserName() + " "
				+ capabilities.getVersion().substring(0, capabilities.getVersion().indexOf("."));
		ExtentTest = extentReports.createTest(context.getName());
		ExtentTest.assignDevice(device);
		driver.get(prop.getProperty("url"));
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@BeforeSuite
	public void initialiseExtentReports() {
		extentReports = new ExtentReports();
		
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
		sparkReporter_all.filter().statusFilter().as(new Status[] {Status.PASS}).apply();
		
		ExtentSparkReporter sparkReporter_failed = new ExtentSparkReporter("FailedTests.html");
		sparkReporter_failed.filter().statusFilter().as(new Status[] { Status.FAIL }).apply();

		ExtentSparkReporter sparkReporter_skipandwarning = new ExtentSparkReporter("skipandwarningTests.html");
		sparkReporter_skipandwarning.filter().statusFilter().as(new Status[] { Status.SKIP, Status.WARNING }).apply();
		extentReports.attachReporter(sparkReporter_all, sparkReporter_failed, sparkReporter_skipandwarning);
	}

	@AfterSuite
	public void generateExtentReport() throws Exception {
		extentReports.flush();
	 Desktop.getDesktop().browse(new File("AllTests.html").toURI()); 
	 Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
	 Desktop.getDesktop().browse(new File("skipandwarningTests.html").toURI()); 
	 }

	@AfterMethod
	public void CheckStatus(Method m, ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentTest.pass(m.getName() + " is passed");

		} else if (result.getStatus() == ITestResult.FAILURE) {
			String ScreenshotPath = null;
			ScreenshotPath = captureScreenShot(
					result.getTestContext().getName() + " " + result.getMethod().getMethodName() + ".jpg");
			ExtentTest.addScreenCaptureFromPath(ScreenshotPath);
			ExtentTest.fail(m.getName() + " is Failed :   " + result.getThrowable());
		}

		ExtentTest.assignCategory(result.getMethod().getMethodName());
	}

	public String captureScreenShot(String fileName) {
		if (ScreenshotSubFolderName == null) {

			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

			ScreenshotSubFolderName = myDateObj.format(myFormatObj);
		}
		
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				"C:\\Users\\Admin\\Downloads\\screenshot\\" + ScreenshotSubFolderName + "/" + fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved Sucessfully");
		return destFile.getAbsolutePath();
	}
	
	public void addTestResultstoTestRail(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {

			TestRailManager.addResultsforTestCase(testCaseID, TestRailManager.TEST_CASE_PASS_STATUS, "");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			TestRailManager.addResultsforTestCase(testCaseID, TestRailManager.TEST_CASE_FAIL_STATUS,
					"Test got failed..." + result.getTestName() + ":FAILED");
		}
	}

}