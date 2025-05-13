package ExtentReports;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportManager{

	//public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	
	
	public static ExtentReports getReportInstance() {
		
		if(report == null) {
			String reportName = DateUtils.getTimeStamp() + ".html";
			//ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output//ExtentReport//" + reportName);
			ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "//test-output//ExtentReport//" + reportName);
			report = new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("OS", "WINDOWS 10");
			report.setSystemInfo("Environment", "UAT");
			report.setSystemInfo("Build Number", "10.8.1");
			report.setSystemInfo("Browser", "chrome");
			
			spark.config().setDocumentTitle("AskMeOffers Report");
			spark.config().setReportName("AskMeOffers UI Test Report");
			spark.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		}
		return report;
	}
}
