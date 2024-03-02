package AutomationProject.StepDefinitions;

import java.io.IOException;

import AutomationProject.Base.TestBase;
import AutomationProject.pageobjects.CartPage;
import AutomationProject.pageobjects.CheckOutPage;
import AutomationProject.pageobjects.ConfirmationPage;
import AutomationProject.pageobjects.Header;
import AutomationProject.pageobjects.OverviewPage;
import AutomationProject.pageobjects.ProductCatalogue;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImp extends TestBase {

	public ProductCatalogue productcatalogue;
	public Header header;
	public CartPage cartpage;
	public CheckOutPage checkoutpage;
	public OverviewPage overviewpage;
	public ConfirmationPage confirmationpage;
	
	@Given("I launch the saucedemo application")
	public void I_launch_the_saucedemo_application() throws IOException
	{
		launchApplication();
	}
	
	@Given("user logged into application using {string} and {string}")
	public void userLogin(String username, String password)
	{
		landingpage.loginApplication(username, password);
	}
	
	@When("user add {string} to cart")
	public void user_add_product_to_cart(String productName)
	{
		productcatalogue = new ProductCatalogue(driver);
        productcatalogue.addProductToCart(productName);
        header = new Header(driver);
		header.goToCartPage();
		cartpage = new CartPage(driver);
		Boolean match = cartpage.verifyProductDisplay(productName);
		Assert.isTrue(match, "no match");
	}
	
	@And("navigate to checkout page and enter {string}, {string} and {string} information")
	public void navigate_to_checkout_page(String firstname, String lastname, String zipcode)
	{
		cartpage.goToCheckoutPage();
		checkoutpage = new CheckOutPage(driver);
		checkoutpage.checkOutInfo(firstname, lastname, zipcode);
		checkoutpage.goToCheckoutOverviewPage();
		overviewpage = new OverviewPage(driver);
		overviewpage.confirmOrder();
	}
	
	@Then("verify the order confirmation {string}")
	public void verify_the_order_confirmation_message(String message)
	{
		confirmationpage = new ConfirmationPage(driver);
		String confirmMessage = confirmationpage.getConfirmationMessage();
		Assert.isTrue(confirmMessage.equalsIgnoreCase(message), "Wrong Confirmation Message");
		driver.close();
	}
	
	@Then("verify the {string}")
	public void verify_the_errormessage(String message)
	{
		String actualMessage = landingpage.getErrorMessage();
		Assert.isTrue(actualMessage.equalsIgnoreCase(message), "Incorrect Error Message");
		driver.close();
	}
}
