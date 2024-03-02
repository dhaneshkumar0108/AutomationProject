package AutomationProject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationProject.Base.PageBase;

public class ProductCatalogue extends PageBase {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".inventory_item")
	List<WebElement> products;
	
	By productsNameBy = By.xpath("//div[contains(@class,'inventory_item_name')]");
	By addToCart = By.xpath("//button[contains(@id,'add-to-cart')]");
	By removeFromCart = By.xpath("//button[contains(@id,'remove')]");
	
	public WebElement getProductsByName(String productName) {
		return products.stream().filter(product -> product.findElement(productsNameBy).getText().equals(productName)).findFirst().orElse(null);
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = getProductsByName(productName);
		prod.findElement(addToCart).click();
		waitForElementVisible(removeFromCart);
	}
	
}
