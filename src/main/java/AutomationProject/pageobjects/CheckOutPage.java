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
	
	@FindBy(id = "first-name")
	WebElement firstName;
	
	@FindBy(id = "last-name")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement zipCode;
	
	@FindBy(id = "continue")
	WebElement checkOutOverviewBtn;
	
	By results= By.cssSelector(".ta-results");
	
	public void checkOutInfo(String firstNameVal, String lastNameVal, String zipCodeVal) {
		setValue(firstName, firstNameVal);
		setValue(lastName, lastNameVal);
		setValue(zipCode, zipCodeVal);
	}
	
	public void goToCheckoutOverviewPage() {
		checkOutOverviewBtn.click();
	}

}
