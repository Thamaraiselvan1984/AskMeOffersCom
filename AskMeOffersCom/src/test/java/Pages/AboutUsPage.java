package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Base.TestBase;


public class AboutUsPage extends TestBase{

	@FindBy(xpath = "//*[@id=\"menu-primary-1\"]/li[2]/a")
    WebElement AboutUsLink;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/div/header/h1")
	WebElement AboutUsText;
	
	private ExtentTest test;
	
	public AboutUsPage(WebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test= test;
	}
	
	public void AboutUsLink() {
		AboutUsLink.click();
	}
	
	public OurHistoryPage AboutUsText() {
		String actual ="About Us – World’s Largest AI-Powered Coupon System";
		String Expected = AboutUsText.getText();
		Assert.assertEquals(actual, Expected, "Text not matching");
		return new OurHistoryPage(driver, test);
	}
}
