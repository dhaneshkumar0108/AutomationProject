package AutomationProject.JavaSeleniumFramework;

import org.testng.annotations.Test;

import AutomationProject.Base.TestBase;
import AutomationProject.pageobjects.CartPage;
import AutomationProject.pageobjects.CheckOutPage;
import AutomationProject.pageobjects.ConfirmationPage;
import AutomationProject.pageobjects.Header;
import AutomationProject.pageobjects.OverviewPage;
import AutomationProject.pageobjects.ProductCatalogue;
import dev.failsafe.internal.util.Assert;

/**
 * Hello world!
 *
 */
public class SubmitOrder extends TestBase
{
	public ProductCatalogue productcatalogue;
	public CartPage cartpage;
	public CheckOutPage checkoutpage;
	public ConfirmationPage confirmationpage;
	public Header header;
	public OverviewPage overviewpage;
	
	String productName = "Sauce Labs Backpack";
	
	
	@Test
	public void submitOrder() throws InterruptedException
	{
        landingpage.loginApplication("standard_user", "secret_sauce");
        productcatalogue = new ProductCatalogue(driver);
        productcatalogue.addProductToCart(productName);
        header = new Header(driver);
		header.goToCartPage();
		cartpage = new CartPage(driver);
		Boolean match = cartpage.verifyProductDisplay(productName);

		Assert.isTrue(match, "no match");
		cartpage.goToCheckoutPage();
		checkoutpage = new CheckOutPage(driver);
		checkoutpage.checkOutInfo("Dhanesh","kumar","12601");
		checkoutpage.goToCheckoutOverviewPage();
		
		overviewpage = new OverviewPage(driver);
		overviewpage.confirmOrder();
		
		confirmationpage = new ConfirmationPage(driver);
		String confirmMessage = confirmationpage.getConfirmationMessage();
		Assert.isTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"), "Wrong Confirmation Message");
    }
}
