package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Base.TestBase;

public class EcommerceNewsPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"menu-primary-1\"]/li[5]/a")
	WebElement EcommerceNewslink;
	
	@FindBy(xpath = "//*[@id=\"primary\"]/header/span/h1/span[2]")
	WebElement EcommerceHeaderText;
	
	public EcommerceNewsPage(WebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test= test;
	}
	
	public void EcommerceNewsPagelink() {
		EcommerceNewslink.click();
	}
	
	public HealthPage EcommerceHeaderText() {
	String actual = "Ecommerce News";
	String expected = EcommerceHeaderText.getText();
	Assert.assertEquals(actual, expected, "EcommerceHeader not matching");
	return new HealthPage(driver, test);
	}
	
}
