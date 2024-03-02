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
	
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	
	By productsBy = By.cssSelector(".mb-3");
	By productsNameBy = By.cssSelector("b");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	By spinner = By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductList() {
		waitForElementVisible(productsBy);
		return products;
	}
	
	public WebElement getProductsByName(String productName) {
		return products.stream().filter(product -> product.findElement(productsNameBy).getText().equals(productName)).findFirst().orElse(null);
	}
	
	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod = getProductsByName(productName);
		prod.findElement(addToCart).click();
		waitForElementVisible(toastMessage);
//		waitForElementInvisible(spinner);
		Thread.sleep(2000);
	}
	
}
