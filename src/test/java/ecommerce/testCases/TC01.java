//Test if a new user can register successfully
package ecommerce.testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.listener.ListenerClass;
import ecommerce.demo.Project1_ECommerce.Amazon_Home_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Register_Page;
import login.LoginClass;


@Listeners(ListenerClass.class)
public class TC01 extends ListenerClass {

	@Test
	//(retryAnalyzer = amazon.retryAnalyzer.AmazonRetryAnalyzer.class)
	public void amazonRegister() {
		
		LoginClass login = new LoginClass();
		login.amazonLaunch();
		
		Amazon_Home_Page homePage = new Amazon_Home_Page(driver);
		homePage.accountAndList(driver);
		homePage.register();
		
		Amazon_Register_Page registerPage = new Amazon_Register_Page(driver);
		if(driver.getTitle().equals("Amazon Registration")) {
			registerPage.name();
			registerPage.mobileNo();
			registerPage.password();
		}
		registerPage.emailId();
		registerPage.mobileNo();
		registerPage.name();
		registerPage.password();
		
	}
	
}
