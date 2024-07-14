//Reach till cart page without login in amazon application

package ecommerce.testCases;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.listener.ListenerClass;
import amazon.retryAnalyzer.AmazonRetryAnalyzer;
import ecommerce.demo.Project1_ECommerce.Amazon_Home_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Product_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Search_Result_Page;
import login.LoginClass;

@Listeners(ListenerClass.class)
public class TC15 extends ListenerClass {

	@Test(retryAnalyzer = AmazonRetryAnalyzer.class)
	public void addToCartWithoutLogin() {
		LoginClass login = new LoginClass();
		login.amazonLaunch();
		
		Amazon_Home_Page homePage = new Amazon_Home_Page(driver);
		homePage.searchProduct();
		
		Amazon_Search_Result_Page resultPage = new Amazon_Search_Result_Page(driver);
		resultPage.selectProduct();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		
		String parentId = iterator.next();
		String childId = iterator.next();
		
		driver.switchTo().window(childId);
		
		Amazon_Product_Page productPage = new Amazon_Product_Page(driver);
		productPage.addtoCart();
		
		Assert.assertEquals(productPage.assertTC15(), true, "Test case 15 failed!");
		
	}
}
