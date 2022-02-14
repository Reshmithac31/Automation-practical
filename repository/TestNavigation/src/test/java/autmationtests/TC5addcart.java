package autmationtests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automationpages.cartpage;

public class TC5addcart {
	
	WebDriver driver;//
	cartpage page;
  @BeforeTest//initiation of chrome browser and website 
  public void setup() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\PraveenReddy\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
  }
  @Test//performing addtocart functionality and validating the cart
  public void validateaddtocart() {
	  
	  Assert.assertTrue(page.validatecart(driver)); //verifying the cart
	  driver.close();
  }
}
