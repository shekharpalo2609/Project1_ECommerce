//Check if the products can be sorted by relevance, price,rating, etc.

package ecommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.listener.ListenerClass;
import amazon.retryAnalyzer.AmazonRetryAnalyzer;
import ecommerce.demo.Project1_ECommerce.Amazon_Home_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Search_Result_Page;
import login.LoginClass;

@Listeners(ListenerClass.class)
public class TC08 extends ListenerClass {
	
	@Test(retryAnalyzer = AmazonRetryAnalyzer.class)
	public void productSorting() throws InterruptedException, IOException {
		
		LoginClass login = new LoginClass();
		login.amazonLaunch();
		login.amazonLogin();
		
		Amazon_Home_Page homePage = new Amazon_Home_Page(driver);
		homePage.searchProduct();
		
		Amazon_Search_Result_Page resultPage = new Amazon_Search_Result_Page(driver);
		Thread.sleep(500);
		resultPage.selectRelevance();
		Thread.sleep(1500);
		driver.navigate().refresh();
		Thread.sleep(2000);
		resultPage.selectPrice();
		Thread.sleep(1500);
		driver.navigate().refresh();
		Thread.sleep(1500);
		resultPage.selectRating();
		driver.navigate().refresh();
		Assert.assertEquals(driver.getTitle(),"Amazon.in : shoe","Test case 8 failed");
	}
	
}
