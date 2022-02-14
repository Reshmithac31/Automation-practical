package automationpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class Searchpage {
	
	public Searchpage(WebDriver driver) {
		//super();
		this.driver = driver;
	}

	public WebDriver driver;

	
	
	@FindBy(id="search_query_top")
	WebElement searchtextbox;
	
	
	@FindBy(id="searchbox > button")
	WebElement searchbutton;
	@FindBy(xpath="//*[@id=\"center_column\"]/h1/span[1]")
	WebElement searchheading;
	
	public WebElement searchtextbox(){
		return searchtextbox;
	}
	
	public WebElement searchbutton(){
		return searchbutton;
		
	}
	public WebElement searchheading(){
		return searchheading;
		
	}

	public WebElement searchtextbox(int i) {
		// TODO Auto-generated method stub
		return searchtextbox;
	}
	
	
	
	
	public void enterText(String str) {
		searchtextbox.sendKeys("shirt");
	}
	
	
	public void clickSearch() {
		searchbutton.click();
	}
	
	public void verfiyText(String str) {
		boolean isAvailable = searchheading.getText().contains(str);
		Assert.assertEquals(isAvailable, true);
	}

}
