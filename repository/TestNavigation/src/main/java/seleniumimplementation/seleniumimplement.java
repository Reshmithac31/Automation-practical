package seleniumimplementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class seleniumimplement {
	
	Actions action;
  @Test
  public void mousehover(WebElement element,WebDriver driver) {
	  action=new Actions(driver);
	  action.moveToElement(element).build().perform();
  }
  public void click(WebElement element) {
	  element.click();
  }
  public void clear(WebElement element) {
	 element.clear();
  }
  public void sendtext(String text,WebElement element) {
		 element.sendKeys(text);
	  }
  public void selectbyvisibletxt(WebElement selectsize,String text) {
		 Select s= new Select(selectsize);
		 s.selectByVisibleText(text);
	  }
  public void prcdcheckoutclick(WebElement element,WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	  }
  public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	  }
  

	public void dispose(WebDriver driver) {
		
		driver.close();
	}
  public boolean validatecart(WebElement element,WebDriver driver,String expected) {
	  String actual=element.getText();
	  if(actual.equals(expected)) {
		  return true;
	  }
	  
	  
	  return false;
  }
  
  
  
  
  
  
  
  
}
