package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;

import Base.TestBase;

public class HealthPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"menu-primary-1\"]/li[6]/a")
	WebElement HealthLink;
	
	@FindBy(xpath = "//*[@id=\"primary\"]/header/span/h1/span[2]")
	WebElement HealthText;
	
	public HealthPage(WebDriver driver, ExtentTest test) {
	 PageFactory.initElements(driver, this);
	  this.test= test;
	}
	
	public void HealthLink() {
		HealthLink.click();
	}
	
	public TechPage HealthText() {
	String actual = "Health";
	String expected = HealthText.getText();
	Assert.assertEquals(actual, expected, "Health header not matching");
	return new TechPage(driver, test);
	}
	

}
