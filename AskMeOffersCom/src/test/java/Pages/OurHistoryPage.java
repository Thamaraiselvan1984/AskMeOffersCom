package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Base.TestBase;

public class OurHistoryPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"menu-primary-1\"]/li[3]/a")
    WebElement OurHistory;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/div/header/h1")
	WebElement OurHistoryText;
	
	public OurHistoryPage(WebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test=test;
	}

	public void OurHistorylink() {
		OurHistory.click();
	}
	
	public BreakingNewsPage OurHistoryText() {
	String actual ="AskmeOffers History: From Bookstore to Leading E-commerce Platform";
	String Expected = OurHistoryText.getText();
	Assert.assertEquals(actual, Expected, "Our History header is not matching");
	return new BreakingNewsPage(driver, test);
	}
	
}
