//Check if the user is able to apply the coupon code while ordering the product.

package ecommerce.testCases;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.listener.ListenerClass;
import amazon.retryAnalyzer.AmazonRetryAnalyzer;
import ecommerce.demo.Project1_ECommerce.Amazon_Address_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Cart_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Home_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_PaymentMethods_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Product_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Search_Result_Page;
import login.LoginClass;

@Listeners(ListenerClass.class)
public class TC13 extends ListenerClass {

	@Test(retryAnalyzer = AmazonRetryAnalyzer.class)
	public void applyCouponCode() throws InterruptedException {

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
		productPage.addtoCart();
		productPage.goToCart();

		Amazon_Cart_Page cartPage = new Amazon_Cart_Page(driver);
		cartPage.selectQuantityFromDropdown();
		cartPage.proceedToBuy();

		Amazon_Address_Page addressPage = new Amazon_Address_Page(driver);
		addressPage.selectAddress();
		addressPage.useThisAddress();

		Amazon_PaymentMethods_Page paymentPage = new Amazon_PaymentMethods_Page(driver);
		paymentPage.enterCoupunCode();

		Assert.assertEquals(paymentPage.assertTc13(), true, "Test case 13 failed");
	}
}