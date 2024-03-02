package AutomationProject.JavaSeleniumFramework;

import org.testng.annotations.Test;

import AutomationProject.Base.TestBase;
import AutomationProject.pageobjects.CartPage;
import AutomationProject.pageobjects.CheckOutPage;
import AutomationProject.pageobjects.ConfirmationPage;
import AutomationProject.pageobjects.Header;
import AutomationProject.pageobjects.OrderPage;
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
	public OrderPage orderspage;
	
	String productName = "ZARA COAT 3";
	
	
	@Test
	public void submitOrder() throws InterruptedException
	{
        landingpage.loginApplication("dhanesh@gmail.com", "India@123");
        productcatalogue = new ProductCatalogue(driver);
        productcatalogue.addProductToCart(productName);
        header = new Header(driver);
		header.goToCartPage();
		cartpage = new CartPage(driver);
		Boolean match = cartpage.verifyProductDisplay(productName);

		Assert.isTrue(match, "no match");
		cartpage.goToCheckoutPage();
		checkoutpage = new CheckOutPage(driver);
		checkoutpage.selectCountry("india");
		checkoutpage.placeOrder();
		
		confirmationpage = new ConfirmationPage(driver);
		String confirmMessage = confirmationpage.getConfirmationMessage();
		Assert.isTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."), "Wrong Confirmation Message");
    }
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		landingpage.loginApplication("dhanesh@gmail.com", "India@123");
		header = new Header(driver);
		header.goToOrdersPage();
		orderspage = new OrderPage(driver);
		Assert.isTrue(orderspage.VerifyOrderDisplay(productName), "Order doesn't Exist");
	}
}
