package autmationtests;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automationpages.Clothes;
import automationpages.submenupage;
import seleniumimplementation.seleniumimplement;

public class TC6submenu {

	submenupage page;// calling page object submenupage
	Clothes clobj;

	@BeforeTest // initiating chrome browser
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PraveenReddy\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		page = new submenupage(driver);
		clobj = new Clothes(page, driver);
	}

	@Test // storing all main menu in a list and iterating based on index dynamically
	public void mainmenu() {
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Women");
		expectedList.add("Dresses");
		for (int i = 0; i < expectedList.size(); i++) {
			Assert.assertTrue(expectedList.get(i).equals(page.sample(i)));

		}
	}

	seleniumimplement selenium;// constructor for seleniumimplement

	public TC6submenu(WebDriver driver) {
		PageFactory.initElements(driver, this);
		selenium = new seleniumimplement();
	}

	WebDriver driver;

	@Test // hovering on main categories and selecting subcategories functionality.
	public void selectdresses() {
		Assert.assertTrue(clobj.getDressesBtn().isDisplayed());
		selenium.mousehover(clobj.getDressesBtn(), this.driver);
		Assert.assertTrue(clobj.getSummerDressesBtn().isDisplayed());
		Assert.assertTrue(clobj.getCasualDressesBtn().isDisplayed());
		Assert.assertTrue(clobj.getEveningDressesBtn().isDisplayed());
		selenium.mousehover(clobj.getSummerDressesBtn(), this.driver);
		clobj.getSummerDressesBtn().click();
		Assert.assertTrue(clobj.getSummerDressProduct(1).isDisplayed());
		Assert.assertTrue(clobj.getSummerDressProduct(2).isDisplayed());
		Assert.assertTrue(clobj.getSummerDressProduct(3).isDisplayed());
	}
}
