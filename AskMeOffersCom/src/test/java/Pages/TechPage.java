package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Base.TestBase;

public class TechPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"menu-primary-1\"]/li[7]/a")
	WebElement Techlink;
	
	@FindBy(xpath = "//*[@id=\"primary\"]/header/span/h1/span[2]")
	WebElement TechHeader;
	
	
	public TechPage(WebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test= test;
	}
	
	public void Techlink() {
		Techlink.click();
	}
	
	public void TechHeader() {
		String actual = "Tech";
		String expected = TechHeader.getText();
		Assert.assertEquals(actual, expected, "TechHeader is not matching");
	}
	
}
