package Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import Base.TestBase;


public class HomePage extends TestBase {

	@FindBy(xpath = "//a[normalize-space()='Home']")
	WebElement HomePageLink;
	
	@FindBy(xpath = "//*[@id=\"masthead\"]/div[2]/div/div[1]/div/p[2]/a")
	WebElement askMeOffersLink;
	
	@FindBy(xpath = "//div[@class='clsgooglebox']")
	WebElement Googlebox;
	
	@FindBy(xpath= "//div[@class='clsgooglebox']//div[@class='clsreviewlabeltitle']")
	WebElement ExcellentTitle;
	
	@FindBy(xpath="//div[@class='clsgooglebox']//following-sibling::label")
	WebElement label;
		
	@FindBy(xpath="//div[@class='clsgooglebox']//div[@class='clsbasedtru']")
	WebElement Text;
	
	@FindBy(xpath="//div[@class='clsgooglebox']//div[@class='clsgooglelevel']")
	WebElement image;
	
	@FindBy(xpath = "//a[@class='clsreadallrev']")
	WebElement readallreview;

	private ExtentTest test;
	
	public HomePage(WebDriver driver, ExtentTest test) {
		
		PageFactory.initElements(driver, this);
		this.test = test;
		
	}

	public void HomePageLink() throws InterruptedException {
		HomePageLink.click();
		Thread.sleep(4000);
	}
	
	public boolean askmeofferslink() {
		return askMeOffersLink.isDisplayed();
	}
	
	public void googlebox() {
	Actions action = new Actions(driver);
	action.moveToElement(Googlebox).build().perform();
	String actual = "'Excellent'";
	String expected = driver.findElement(By.xpath("//div[@class='clsgooglebox']//div[@class='clsreviewlabeltitle']")).getText();
	Assert.assertEquals(actual, expected, "HEADER IS NOT MACHING");
	System.out.println("Excellent header is displayed : " + ExcellentTitle.isDisplayed());
	
	List<WebElement> listoflabel = driver.findElements(By.xpath("//div[@class='clsgooglebox']//following-sibling::label"));
	for(WebElement list:listoflabel) {
		System.out.println(list.getAttribute("title"));
	}
	System.out.println(Text.getText());
	System.out.println("Google image is displayed : " + image.isDisplayed());
	readallreview.click();
	}
	
	
	public AboutUsPage returnlink() {
		return new AboutUsPage(driver, test);
	}
	

	
}
