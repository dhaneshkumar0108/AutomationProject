package AutomationProject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationProject.Base.PageBase;

public class LandingPage extends PageBase{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	WebElement userEmail;
	
	@FindBy(id = "password")
	WebElement userPassword;
	
	@FindBy(id = "login-button")
	WebElement login;
	
	@FindBy(xpath = "//div[contains(@class,'error-message')]")
	WebElement errorMsg;
	
	public void loginApplication(String username, String password)
	{
		userEmail.sendKeys(username);
        userPassword.sendKeys(password);
        login.click();
	}
	
	public void goTo()
	{
		driver.get("https://www.saucedemo.com/");
	}
	
	public String getErrorMessage()
	{
		waitForElementVisibility(errorMsg);
		return errorMsg.getText();
	}
}
