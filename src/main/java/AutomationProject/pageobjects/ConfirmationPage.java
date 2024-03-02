package AutomationProject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationProject.Base.PageBase;

public class ConfirmationPage extends PageBase{
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".complete-header")
	WebElement confirmationMsg;	
	
	public String getConfirmationMessage() {
		return confirmationMsg.getText();
	}

}
