package AutomationProject.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationProject.Base.PageBase;

public class CartPage extends PageBase{

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".inventory_item_name")
	List<WebElement> cartProducts;
	
	@FindBy(id = "checkout")
	WebElement checkOutBtn;
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public void goToCheckoutPage() {
		checkOutBtn.click();
	}

}
