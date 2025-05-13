package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;

import org.testng.Assert;

import Base.TestBase;

public class BreakingNewsPage extends TestBase{
	
	@FindBy(xpath = "//*[@id=\"menu-primary-1\"]/li[4]/a")
	WebElement BreakingNewslink;
	
	@FindBy(xpath = "//*[@id=\"primary\"]/header/span/h1/span[2]")
	WebElement BreakingNewsHeader;
	
	public BreakingNewsPage(WebDriver driver, ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test = test;
		
	}
	
	public void BreakingNewslink(){
		BreakingNewslink.click();
	}
	
	public EcommerceNewsPage BreakingNewsHeader() {
	String actual = "Breaking News";
	String expected = BreakingNewsHeader.getText();
	Assert.assertEquals(actual, expected, "BreakingNewsHeader is not matching");
	return new EcommerceNewsPage(driver, test);
	}
	
}
