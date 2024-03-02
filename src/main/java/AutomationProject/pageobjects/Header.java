package AutomationProject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationProject.Base.PageBase;

public class Header extends PageBase{

	WebDriver driver;
	
	public Header(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".shopping_cart_link")
	WebElement cart;
	
	public void goToCartPage() {
		cart.click();
	}
}
