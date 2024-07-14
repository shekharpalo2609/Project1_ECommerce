//Ensure login fails with incorrect email or password

package ecommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.listener.ListenerClass;
import amazon.retryAnalyzer.AmazonRetryAnalyzer;
import ecommerce.demo.Project1_ECommerce.Amazon_Home_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_InvalidLogin_Page;
import login.LoginClass;

@Listeners(ListenerClass.class)
public class TC03 extends ListenerClass {

	@Test(retryAnalyzer = AmazonRetryAnalyzer.class)
	public void amazonLoginWithInvalidCredentials() throws InterruptedException {

		LoginClass login = new LoginClass(); 
		login.amazonLaunch();
		  
		Amazon_Home_Page homePage = new Amazon_Home_Page(driver);
		homePage.accountAndList(driver);
		homePage.signIn();
		
		Amazon_InvalidLogin_Page invalidLogin = new Amazon_InvalidLogin_Page(driver);
		invalidLogin.emailID();
		Thread.sleep(1000);
		invalidLogin.password();
		Assert.assertEquals(invalidLogin.assertTC03(), true, "Test case 3 failed"); ;
	}
}
