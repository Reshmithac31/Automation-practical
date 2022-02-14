package automationpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpage {

	WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public loginpage(WebDriver driver) {
          this.driver = driver;
	}
	
	By btn = By.className("login");
	//Locator for username field
	WebElement username=driver.findElement(By.id("email"));
	

	
	//Locator for password field
	By pswd = By.id("passwd");
	
	//Locator for login button
	By loginBtn = By.xpath("//*[@id=\"SubmitLogin\"]/span");

	
	WebElement accname=driver.findElement(By.xpath("//*[@id=\\\"header\\\"]/div[2]/div/div/nav/div[1]/a/span"));
	
	public void clickbtn(){
		driver.findElement(btn).click();
	}
	
	//Method to enter username
	public void enterUsername(String user) {
		driver.findElement((By) username).sendKeys(user);
	}

	//Method to enter password
	public void enterPassword(String pass) {
		driver.findElement(pswd).sendKeys(pass);
	}
	
	//Method to click on Login button
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	public boolean accountname(){
		return accname.isDisplayed();
	}
	
}