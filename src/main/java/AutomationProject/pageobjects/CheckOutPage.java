package AutomationProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationProject.Base.PageBase;

public class CheckOutPage extends PageBase{
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(css = ".totalRow button")
	WebElement checkOutBtn;
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement searchResult;
	
	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement placeOrder;
	
	By results= By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		setValue(selectCountry, countryName);
		waitForElementVisible(results);
		searchResult.click();
	}
	
	public void goToCheckoutPage() {
		checkOutBtn.click();
	}
	
	public void placeOrder() {
		javascriptExecutorClick(placeOrder);
	}

}
