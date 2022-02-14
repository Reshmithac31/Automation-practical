package automationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumimplementation.seleniumimplement;
import utils.Utils;

public class submenupage {

	WebDriver driver;
	seleniumimplement selenium;
	Utils obj;
	@FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
	WebElement txtqnty;
	@FindBy(xpath = "//*[@id=\"group_1\"]")
	WebElement slctsize;
	String template = "//div[@id=\"block_top_menu\"]/ul/li[${index}]/a";

	public submenupage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
		selenium = new seleniumimplement();
		obj = new Utils(driver);
	}

	public String sample(Integer index) {
		System.out.print("BEfore -" + template);
		String xpathquery = template.replaceFirst("${index}", index.toString());
		System.out.print("Afetr -" + xpathquery);
		WebElement elem = this.driver.findElement(By.xpath(xpathquery));
		selenium.mousehover(elem, this.driver);
		elem.findElement(By.xpath(xpathquery));
		return elem.getText();
	}
}
