package autmationtests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import automationpages.loginpage;
import seleniumimplementation.GlobalVariables;

public class TC4Signin {
	@BeforeTest
	public WebDriver init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PraveenReddy\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		return driver;
	}
	
	@Test

	public void signingin() throws InterruptedException {
		WebDriver driver = init();
		loginpage login = new loginpage(driver);
		//Enter username & password
		login.enterUsername(GlobalVariables.USERNAME);
		login.enterPassword(GlobalVariables.PASSWORD);
		//Click on login button
		login.clickLogin();
		Thread.sleep(3000);
		Assert.assertTrue(login.accountname());
		driver.close();
	}
}
