package automationpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumimplementation.seleniumimplement;

public class cartpage {
	@FindBy(xpath="//*[@id=\"homefeatured\"]/li[3]/div/div[1]/div/a[1]/img")
	WebElement item;
	@FindBy(xpath="//*[@id=\"homefeatured\"]/li[3]/div/div[2]/div[2]/a[2]/span")
	WebElement morebtn;
	@FindBy(xpath="//*[@id=\"quantity_wanted\"]")
	WebElement txtqnty;
	@FindBy(xpath="//*[@id=\"group_1\"]")
	WebElement slctsize;
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")
	WebElement addtocart;
	@FindBy(css="#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")
	WebElement btnprcdcheckout;
	@FindBy(css="//*[@id=\"header\"]/div[3]/div/di"
			+ "/div[3]/div/a")
	WebElement carttext;
	@FindBy(css="//*[@id=\"our_price_display\"]")
	WebElement unitprice;
	
	
	//calling seleniumimplement in this class
	seleniumimplement selenium;
	//constructor for seleniumimplement
	public cartpage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		selenium=new seleniumimplement();
		
	}
	//performing addtocart functionality
	public boolean validatecart(WebDriver driver) {
		selenium.mousehover(item, driver);
		selenium.clear(morebtn);
		selenium.clear(txtqnty);
		selenium.sendtext("3", txtqnty);
		selenium.selectbyvisibletxt(slctsize, "M");
		selenium.click(addtocart);
		selenium.prcdcheckoutclick(btnprcdcheckout, driver);
		return selenium.validatecart(carttext, driver, "3");
	}
	
	@FindBy(css="//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
	WebElement viewcart;
	
	@FindBy(className="icon-plus")
	WebElement increasequantity;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]/span")
	WebElement checkout;
	
	// public returntypename()
	// {return }
	
	
	public WebElement addtocart(){
		return addtocart;
		
	}
	
	public WebElement viewcart(){
		return viewcart;
		
	}
	public WebElement increasequantity(){
		return increasequantity;
		
	}
	
	public WebElement checkout(){
		return checkout;
		
	}
}
