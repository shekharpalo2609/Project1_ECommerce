//Validate the entire checkout process, including address selection, payment method selection, and order review.

package ecommerce.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.listener.ListenerClass;
import ecommerce.demo.Project1_ECommerce.Amazon_Address_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Cart_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Home_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_PaymentMethods_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Product_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Search_Result_Page;
import login.LoginClass;

@Listeners(ListenerClass.class)
public class TC11 extends ListenerClass {

	@Test
	// (retryAnalyzer = AmazonRetryAnalyzer.class)
	public void checkoutProcess() throws InterruptedException, IOException, AWTException {

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
		paymentPage.selectPayment();
		Thread.sleep(1000);
		paymentPage.enterCardDetail(); 
		paymentPage.switchToIframe(driver);
		paymentPage.enterCardNumber(); 
		paymentPage.expiryMonth();
		paymentPage.expiryYear();
		paymentPage.saveCardDetails();
		Thread.sleep(1500);
		driver.switchTo().defaultContent();
		
		//ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		// 	Robot e1= new Robot();
		 //	e1.keyPress(KeyEvent.VK_ESCAPE);
		 //	driver.switchTo().alert().dismiss();
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.visibilityOf(paymentPage.en));
		 * wait.until(ExpectedConditions.elementToBeClickable(element));
		 */
		paymentPage.enterCvvNumber();
		
		
		// Assert.assertEquals(driver.getTitle(),"Amazon.in Shopping Cart","Test case 11 failed");
	}
}


