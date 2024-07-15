//Test searching for products using its name like shoe

package ecommerce.testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.listener.ListenerClass;
import amazon.retryAnalyzer.AmazonRetryAnalyzer;
import ecommerce.demo.Project1_ECommerce.Amazon_Home_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Search_Result_Page;
import login.LoginClass;
@Listeners(ListenerClass.class)
public class TC05 extends ListenerClass {

	@Test(retryAnalyzer = AmazonRetryAnalyzer.class)
	public void amazonSearchProduct() throws EncryptedDocumentException, IOException {
		
		LoginClass login = new LoginClass();
		login.amazonLaunch();
		login.amazonLogin();
		
		Amazon_Home_Page homePage = new Amazon_Home_Page(driver);
		homePage.searchProduct();
		
		Amazon_Search_Result_Page resultPage = new Amazon_Search_Result_Page(driver);
		Assert.assertEquals(resultPage.assertTC05(), true, "Test case 5 failed");  
		
	}
}
