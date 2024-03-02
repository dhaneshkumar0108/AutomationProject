package AutomationProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationProject.Base.PageBase;

public class OverviewPage extends PageBase{
	
	WebDriver driver;
	
	public OverviewPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "finish")
	WebElement finishBtn;
	
	@FindBy(id = "continue")
	WebElement checkOutOverviewBtn;
	
	By overViewTitle= By.xpath("//span[text()='Checkout: Overview']");
	
	public void confirmOrder() {
		waitForElementVisible(overViewTitle);
		finishBtn.click();
	}

}
