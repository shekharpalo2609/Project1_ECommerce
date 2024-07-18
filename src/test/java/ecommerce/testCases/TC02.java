//Verify login is successful with correct email and password
package ecommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.listener.ListenerClass;
import amazon.retryAnalyzer.AmazonRetryAnalyzer;
import ecommerce.demo.Project1_ECommerce.Amazon_Home_Page;
import login.LoginClass;

@Listeners(ListenerClass.class)
public class TC02 extends ListenerClass {

	@Test(retryAnalyzer = AmazonRetryAnalyzer.class)
	public void amazonLoginWithValidCredentials() throws IOException {

		LoginClass login = new LoginClass();
		login.amazonLaunch();
		login.amazonLogin();

		Amazon_Home_Page homePage = new Amazon_Home_Page(driver);
		Assert.assertEquals(homePage.assertTC02(), true, "Test case 2 failed!");

	}
}