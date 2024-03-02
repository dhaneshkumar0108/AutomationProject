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
	
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement userPassword;
	
	@FindBy(id = "login")
	WebElement login;
	
	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	WebElement errorMsg;
	
	public void loginApplication(String username, String password)
	{
		userEmail.sendKeys(username);
        userPassword.sendKeys(password);
        login.click();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage()
	{
		waitForElementVisibility(errorMsg);
		return errorMsg.getText();
	}
}
