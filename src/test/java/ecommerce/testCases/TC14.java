//Go to orders page and click on your last ordered product and give 5 star ratings.

package ecommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.listener.ListenerClass;
import amazon.retryAnalyzer.AmazonRetryAnalyzer;
import ecommerce.demo.Project1_ECommerce.Amazon_Home_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Orders_Page;
import login.LoginClass;

@Listeners(ListenerClass.class)
public class TC14 extends ListenerClass {

	@Test(retryAnalyzer = AmazonRetryAnalyzer.class)
	public void lastOrderedProductRating() throws InterruptedException, IOException {

		LoginClass login = new LoginClass();
		login.amazonLaunch();
		login.amazonLogin();

		Amazon_Home_Page homePage = new Amazon_Home_Page(driver);
		homePage.returnsAndOrders();

		Amazon_Orders_Page ordersPage = new Amazon_Orders_Page(driver);
		ordersPage.orderPalcedDate();
		ordersPage.productReview();
		Thread.sleep(800);
		ordersPage.rateFiveStar();
		Thread.sleep(1000);
		ordersPage.clearRating();
		
		Assert.assertEquals(ordersPage.assertTC14(), true, "Test case 14 failed");

	}
}
