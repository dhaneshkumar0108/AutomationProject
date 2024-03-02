package AutomationProject.JavaSeleniumFramework;

import org.testng.annotations.Test;
import AutomationProject.Base.TestBase;
import dev.failsafe.internal.util.Assert;

/**
 * Hello world!
 *
 */
public class ErrorValidation extends TestBase
{
	
	@Test
	public void invalidLogin()
	{
		landingpage.loginApplication("userdummy", "passworddummy");
		String actualMessage = landingpage.getErrorMessage();
		Assert.isTrue(actualMessage.equalsIgnoreCase("Epic sadface: Username and password do not match any user in this service"), "Incorrect Error Message");
    }
	
	@Test
	public void LockedOutUser()
	{
        landingpage.loginApplication("locked_out_user", "secret_sauce");
        String message = landingpage.getErrorMessage();
		Assert.isTrue(message.equalsIgnoreCase("Sorry, this user has been locked out."), "Incorrect Error Message");
    }
}
