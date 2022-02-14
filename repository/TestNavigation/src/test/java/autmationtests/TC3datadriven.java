package autmationtests;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import automationpages.Datadriven;
import automationpages.Searchpage;

public class TC3datadriven {
	Searchpage page;
	@BeforeTest//performs initiation of chrome browser
	public WebDriver init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PraveenReddy\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		Thread.sleep(3000);
		return driver;
	}
	
	@Test
  public void searchbydata() throws IOException, InterruptedException {
	  Datadriven d=new Datadriven();
	  ArrayList<String> data=d.getdata("search");
	  data.get(0);
		WebDriver driver = init();
		Searchpage search = new Searchpage(driver);
		WebElement textbox=driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
	    textbox.sendKeys(data.get(0));//This line fetches data from excel sheet
		search.clickSearch();
		search.verfiyText(textbox.getText());
	
}
}
