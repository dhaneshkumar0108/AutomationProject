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
        landingpage.loginApplication("dhanesh@gmail.com", "India@1234");
        String message = landingpage.getErrorMessage();
		Assert.isTrue(message.equalsIgnoreCase("Incorrect email or passwords."), "Incorrect Error Message");
    }
}
