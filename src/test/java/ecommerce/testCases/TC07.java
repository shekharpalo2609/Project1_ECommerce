//Ensure that the product detail page displays all the necessary information such as price, reviews, description

package ecommerce.testCases;

import java.io.IOException;
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
public class TC07 extends ListenerClass {
	
	@Test(retryAnalyzer = AmazonRetryAnalyzer.class)
	public void verifyElements() throws IOException{
	
		LoginClass login = new LoginClass();
		login.amazonLaunch();
		login.amazonLogin();
		
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
		boolean price = productPage.checkProductPrice();
		boolean reviews = productPage.checkCustomerReviews();
		boolean description  = productPage.checkProductDescription();
		if(price == true) {
			System.out.println("Product price is present!");
		}
		else {
			System.out.println("Product price is not present!");
		}
		
		if(reviews == true) {
			System.out.println("Product reviews is present!");
		}
		else {
			System.out.println("Product reviews is not present!");
		}
		
		if(description == true) {
			System.out.println("Product description is present!");
		}
		else {
			System.out.println("Product description is not present!");
		}
		
		Assert.assertEquals(productPage.assertTC07(), true, "Test case 7 failed");
	}
}
