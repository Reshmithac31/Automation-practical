package autmationtests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automationpages.Searchpage;

public class TC1andTC2search {

	Searchpage page;//calling the page object in testcase
@BeforeTest//performs initiation of chrome browser
	public WebDriver init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PraveenReddy\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		Thread.sleep(3000);
		return driver;
	}
//Testcase to perform search operation and verify the result
	@Test

	public void Homenavigation() throws InterruptedException {
		WebDriver driver = init();
		Searchpage search = new Searchpage(driver);
		search.enterText("shirt");
		search.clickSearch();
		search.verfiyText("shirt");
		driver.close();
	}
//This method splits the search criteria ,store them in an array and perform each search operation through the loop
	@Test
	public void searchloop() throws InterruptedException {
		String src = "shirt,dress,top";
		String[] arrsrc = src.split(",");
		for (String text : arrsrc) {
			WebDriver driver = init();
			Searchpage search = new Searchpage(driver);
			search.enterText(text);
			search.clickSearch();
			search.verfiyText(text);
			driver.close();
		}

	}
}
