package Pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseTest.basetest;
import BaseTest.GetLinkStatus;

public class HomePage extends basetest {
	
	@Test(priority = 1, groups= {"SmokeTest"}, testName = "AskMeOfferLinkTest")
	public void AskMeOfferLinkTest() {
		testCaseID = "1";
		ExtentTest.info("Goto Askmeoffers homepage");
		boolean flag = driver.findElement(By.xpath("//a[normalize-space()='askmeoffers.com']")).isDisplayed();
		ExtentTest.info("Verify the Askmeoffers link text in the home page");
		Assert.assertEquals(flag, true);
	}

	@Test(priority = 2, groups= {"SmokeTest"}, testName = "SearchBarTest")
	public void SearchBarTest() throws InterruptedException {
		testCaseID = "2";
		ExtentTest.info("Goto Askmeoffers homepage");
		ExtentTest.info("Click on search engine in the home page");
		driver.findElement(By.id("headserpp")).click();
		Thread.sleep(4000);
		ExtentTest.info("Type byjus in the search bar and hit enter button");
		driver.findElement(By.id("my-input-inside")).sendKeys("byjus", Keys.ENTER);
		Thread.sleep(4000);
		List<WebElement> results = driver.findElements(By.xpath("//div[@role='list']"));
		for (WebElement element : results) {
		ExtentTest.info("Verify the search result displayed in the search : " + element.getText().trim());
		}
		driver.findElement(By.xpath("//a[@aria-label='Close Search']")).click();
		Thread.sleep(4000);
	}

	@Test(priority = 3, groups= {"SmokeTest"}, testName = "CarouselDisplayTest")
	public void CarouselDisplayTest() {
		  testCaseID = "3";
		  ExtentTest.info("Goto Askmeoffers homepage");
		  WebElement image1 = driver.findElement(By.xpath("//div[@aria-hidden='false']//amp-img[1]"));
		  WebElement image2 = driver.findElement(By.xpath("//amp-img[@alt='Uncover Stories, Make Informed Choices: Explore Reviews, Connect with Sellers.']")); 
		  WebElement image3 = driver.findElement(By.xpath("//amp-img[@alt='Reviews: Where Truth Intersects with Consumer Experience. Discover the Genuine Voices of Satisfaction and Insight as Consumers Share their Perspectives.']"));
		  ExtentTest.info("Verify the functionality of the carousel in the homepage");
		  WebElement carousel = driver.findElement(By.xpath("//amp-carousel[@aria-label='Carousel with autoplay']"));
		  carousel.click();
		  for(int i=0;i<4;i++)
		  {
		  WebDriverWait wait = new WebDriverWait(driver, 3000);
		  wait.until(ExpectedConditions.or(
				  ExpectedConditions.visibilityOf(image2),
				  ExpectedConditions.visibilityOf(image1)));
		  } 
	}
	
	@Test(priority = 4, groups= {"SmokeTest"}, testName = "SocialNavigationLinkTest")
	public void SocialNavigationLinkTest() throws InterruptedException {
	ExtentTest.info("Goto Askmeoffers homepage");
	driver.findElement(By.xpath("//div[@id='social-nav-contain_new']")).isSelected();	
	ExtentTest.info("Click on Social Navigation icons in the home page");
	List<WebElement> Listofelement =driver.findElements(By.xpath("//ul[@id='menu-social-links-1']/li"));
	ExtentTest.info("Social Navigation should open : "+ Listofelement.size() + " Pages");
	for (WebElement webele : Listofelement) {
	if(webele.getText().trim().equals("Facebook")) {
			webele.click();
			}
			else if (webele.getText().trim().equals("Twitter")) {
				webele.click();
			}
			else if (webele.getText().trim().equals("Instagram")) {
			webele.click();
			}
			else if (webele.getText().trim().equals("LinkedIn")) {
				webele.click();
				}
			else if (webele.getText().trim().equals("YouTube")) {
				webele.click();
				}
			else if (webele.getText().trim().equals("Pinterest")) {
				webele.click();
				}
	
	    ExtentTest.info("User able to open the page : " + webele.getText());	
	   	}
		Thread.sleep(5000);
		ExtentTest.info("Close the windows");
		String mainwindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1= s1.iterator();
		while(i1.hasNext()) {
			String ChildWindow = i1.next();
			if(!mainwindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow).close();
			}
		}   
		}
     

	@Test(priority = 5, groups= {"SmokeTest"}, testName = "PromocodeframeTest")
	public void PromocodeframeTest() throws InterruptedException {
		testCaseID = "5";
		ExtentTest.info("Goto Askmeoffers homepage");
		ExtentTest.info("Click on Promocodeframe in the home page");
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//img[@fetchpriority='high']"));
		act.moveToElement(element).build().perform();

		element.click();
		ExtentTest.info("Click on Ecommerce link Text in the promo code page");
		driver.findElement(By.xpath("//a[@rel='category tag']")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		ExtentTest.info("Click on Social network icon in the page");
		driver.findElement(By.xpath("//amp-social-share[@title='Click to share on Facebook']")).click();
		driver.findElement(By.xpath("//amp-social-share[@title='Click to share on Email']")).click();
	    driver.findElement(By.xpath("//amp-social-share[@title='Click to share on LinkedIn']")).click();
	    driver.findElement(By.xpath("//amp-social-share[@title='Click to share on Twitter']")).click();
	    driver.findElement(By.xpath("//amp-social-share[@title='Click to share on Pinterest']")).click();
	    driver.findElement(By.xpath("//amp-social-share[@title='Click to share on WhatsApp']")).click();
	    Thread.sleep(1000);
	    String mainwindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1= s1.iterator();
		while(i1.hasNext()) {
			String ChildWindow = i1.next();
			if(!mainwindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow).close();
			}
		}   
	}
	
	
	
	@Test(priority = 6, groups={"SmokeTest"}, testName = "CouponslinkTest")
	public void CouponslinkTest() throws InterruptedException {
		ExtentTest.info("Goto Askmeoffers homepage");
		ExtentTest.info("Click on Promocodeframe in the home page");
		Actions act = new Actions(driver);
		WebElement promocode = driver.findElement(By.xpath("//img[@fetchpriority='high']"));
	    act.moveToElement(promocode).build().perform();
	    promocode.click();
	    Thread.sleep(2000);
		WebElement installCoupon = driver.findElement(By.xpath("//div[@class='wp-block-buttons is-content-justification-center is-layout-flex wp-container-core-buttons-is-layout-1 wp-block-buttons-is-layout-flex']//a[@class='wp-block-button__link has-primary-variation-background-color has-background wp-element-button'][normalize-space()='Install AskmeOffers Coupons Extension!']"));
		WebElement installOnMac = driver.findElement(By.xpath("//a[normalize-space()='AskmeOffers Coupons Extension for Chrome on Mac']"));
		WebElement installOnwin = driver.findElement(By.xpath("//a[contains(text(),'AskmeOffers Coupons Extension for Chrome on Window')]"));
		ExtentTest.info("Verify 'Install AskMeOffers Coupons Extension!' link" );
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(602, 394)", " ");
		installCoupon.click();
		Thread.sleep(5000);
		String mainwindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1= s1.iterator();
		while(i1.hasNext()) {
			String ChildWindow = i1.next();
			if(!mainwindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow).close();
			}
			driver.switchTo().window(mainwindow);
		}
		Thread.sleep(2000);
		ExtentTest.info("Verify 'AskMeOffers Coupons Extension for Chrome on MAC' link" );
		JavascriptExecutor jsmac = (JavascriptExecutor) driver;
		jsmac.executeScript("window.scrollBy(571, 224)", " ");
		installOnMac.click();
		Thread.sleep(5000);
		String mainwindow1 = driver.getWindowHandle();
		Set<String> s11 = driver.getWindowHandles();
		Iterator<String> i11= s11.iterator();
		while(i11.hasNext()) {
			String ChildWindow = i11.next();
			if(!mainwindow1.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow).close();
			}
			driver.switchTo().window(mainwindow1);
		}
		Thread.sleep(2000);
		ExtentTest.info("Verify 'AskMeOffers Coupons Extension for Chrome on Windows' link" );
		JavascriptExecutor jswin = (JavascriptExecutor) driver;
		jswin.executeScript("window.scrollBy(648, 327)", " ");
		installOnwin.click();
		Thread.sleep(5000);
		String mainwindow2 = driver.getWindowHandle();
		Set<String> s12 = driver.getWindowHandles();
		Iterator<String> i12= s12.iterator();
		while(i12.hasNext()) {
			String ChildWindow = i12.next();
			if(!mainwindow2.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow).close();
			}
			driver.switchTo().window(mainwindow2);
		}
	  }
	
	
	  @Test(priority = 7, groups={"SmokeTest"}, testName = "FlexClipLinkTest") 
	  public void FlexCliplinkTest() throws InterruptedException, IOException {
		    ExtentTest.info("Goto Askmeoffers homepage");
		    ExtentTest.info("Click on FlexClipLinkText in the HomePage");
		    Actions act = new Actions(driver);
			WebElement Flexclip = driver.findElement(By.xpath("//*[@id=\"post-1195870\"]/div/div[1]/div[2]/div[1]/div/article/figure/a/amp-img/img"));
			act.moveToElement(Flexclip).build().perform();
			Flexclip.click();
			Thread.sleep(3000);
			ExtentTest.info("Verify the Broken links in FlexClip page");
			List<WebElement> links = driver.findElements(By.tagName("a"));
			ExtentTest.info("Verify total no of links in FlexClip page : " + links.size() + " links");
			System.out.println("No of links are :" + links.size());
			for (WebElement link : links) {
				String URL = link.getAttribute("href");
				GetLinkStatus.verifyLink(URL);
			}
			GetLinkStatus.getInvalidLinkCount();			
	  	}
	  
	  @Test(priority = 8, groups={"SmokeTest"}, testName = "SearchResultPageTest")
	  public void SearchResultPageTest() throws InterruptedException {
		    driver.findElement(By.id("headserpp")).click();
			driver.findElement(By.id("my-input-inside")).sendKeys("amazon" , Keys.ENTER);
			Thread.sleep(4000);
			List<WebElement> results = driver.findElements(By.xpath("//div[@role='list']//p"));
			
			for(int i=0; i<results.size(); i++) {
				if(results.get(i).getText().contains("amazon.in")) {
					results.get(i).click();
					break;
				}
			}
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("//p[@class='site-title']/a")).click();	
	  }
	  
	  @Test(priority = 9, groups={"SmokeTest"}, testName = "WebTableTest")
	  public void WebTableTest() throws InterruptedException {
		  WebElement article = driver.findElement(By.xpath("//article[@data-post-id=\"1347560\"]/div/h2/a"));
			JavascriptExecutor linktext = (JavascriptExecutor) driver;
			linktext.executeScript("window.scrollBy(1008, 227)", " ");
			article.click();
			Thread.sleep(2000);
			linktext.executeScript("window.scrollBy(605, 182)", " ");
			WebElement table = driver.findElement(By.xpath("//figure[@class=\"wp-block-table\"]/table"));
			List<WebElement> header_rows = table.findElements(By.xpath(".//thead/tr/th"));
			header_rows.forEach(headervalue -> System.out.println(headervalue.getText()));
			Thread.sleep(2000);
			List<WebElement> tablebody_rows = table.findElements(By.xpath(".//tbody/tr/td"));
			tablebody_rows.forEach(value-> System.out.println(value.getText()));
	  }
	  
	  @Test(priority = 10, groups={"SmokeTest"}, testName = "TopDealsTest")
	  public void TopDealsTest() {
	 
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(868, 274)", " ");
				
			List<WebElement> article = driver.findElements(By.xpath("//div[@class='clsdealcontent']//following-sibling::amp-img"));
			List<WebElement> headers = driver.findElements(By.xpath("//div[@class='clsdealcontent']/descendant::h3"));
			List<WebElement> paragraph = driver.findElements(By.xpath("//div[@class='subclsdealcontent']/descendant::p"));
			
			for(WebElement img : article ) {
				String img1 = img.getAttribute("alt");
				if(img1.contains("ALIEXPRESS")) {
					System.out.println(img1);
					headers.stream().filter(x -> "ALIEXPRESS DEALS".equalsIgnoreCase(x.getText())).collect(Collectors.toList()).forEach(x -> System.out.println(x.getText()));
					js.executeScript("window.scrollBy(868, 274)", " ");
					driver.findElement(By.xpath("//a[@title='View ALIEXPRESS Deals']")).click();
					System.out.println(driver.getTitle());
					driver.navigate().back();
				} else if(img1.contains("OYOROOMS")) {
					System.out.println(img1);
					headers.stream().filter(x -> "OYOROOMS DEALS".equalsIgnoreCase(x.getText())).collect(Collectors.toList()).forEach(x -> System.out.println(x.getText()));
					js.executeScript("window.scrollBy(953, 414)", " ");
					driver.findElement(By.xpath("//a[@title='View OYOROOMS Deals']")).click();
					System.out.println(driver.getTitle());
					driver.navigate().back();
				} else if(img1.contains("GODADDY")) {
					System.out.println(img1);
					headers.stream().filter(x -> "GODADDY DEALS".equalsIgnoreCase(x.getText())).collect(Collectors.toList()).forEach(x -> System.out.println(x.getText()));
					js.executeScript("window.scrollBy(953, 414)", " ");
					driver.findElement(By.xpath("//a[@title='View GODADDY Deals']")).click();
					System.out.println(driver.getTitle());
					driver.navigate().back();
				} else if(img1.contains("ENEBA")) {
					System.out.println(img1);
					headers.stream().filter(x -> "ENEBA DEALS".equalsIgnoreCase(x.getText())).collect(Collectors.toList()).forEach(x -> System.out.println(x.getText()));
					js.executeScript("window.scrollBy(953, 414)", " ");
					driver.findElement(By.xpath("//a[@title='View ENEBA Deals']")).click();
					System.out.println(driver.getTitle());
					driver.navigate().back();
				} else if(img1.contains("MYNTRA")){
					System.out.println(img1);
					headers.stream().filter(x -> "MYNTRA DEALS".equalsIgnoreCase(x.getText())).collect(Collectors.toList()).forEach(x -> System.out.println(x.getText()));
					js.executeScript("window.scrollBy(953, 414)", " ");
					driver.findElement(By.xpath("//a[@title='View MYNTRA Deals']")).click();
				    System.out.println(driver.getTitle());
				    driver.navigate().back();
					break;
				}
			}
			System.out.println("*****Paragraphs*****");
			paragraph.forEach(x -> System.out.println(x.getText()));
	}
}
