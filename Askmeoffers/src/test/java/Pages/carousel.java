package Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class carousel
{	
	public static WebDriver driver;
	
	@Test
	public void PromocodeframeTest() throws InterruptedException, IOException {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\selenium\\Chrome130\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://askmeoffers.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebElement ele = driver.findElement(By.xpath("//div[@class='innerblock_trustpilot clsfirstslider']"));
	Actions act = new Actions(driver);
    act.moveToElement(ele).build().perform();
    ele.isSelected();
	String Actual = "'Excellent'";
	String expected = driver.findElement(By.className("clsreviewlabeltitle")).getText();
	Assert.assertEquals(Actual, expected, "header not matching");
	
	}
}