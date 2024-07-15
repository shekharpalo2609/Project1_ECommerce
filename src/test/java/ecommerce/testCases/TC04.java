//Check if the user is successfully edit the profile information

package ecommerce.testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.listener.ListenerClass;
import amazon.retryAnalyzer.AmazonRetryAnalyzer;
import ecommerce.demo.Project1_ECommerce.Amazon_Home_Page;
import ecommerce.demo.Project1_ECommerce.Amazon_Profile_Page;
import login.LoginClass;

@Listeners(ListenerClass.class)
public class TC04 extends ListenerClass {

	@Test // (retryAnalyzer = AmazonRetryAnalyzer.class)
	public void amazonEditProfile() throws IOException, InterruptedException {

		LoginClass login = new LoginClass();
		login.amazonLaunch();
		login.amazonLogin();

		Amazon_Home_Page homePage = new Amazon_Home_Page(driver);
		homePage.accountAndList(driver);

		homePage.manageProfile();
		System.out.println("Before Amazon page");

		Amazon_Profile_Page profilePage = new Amazon_Profile_Page(driver);
		System.out.println("Amazon page");
		Thread.sleep(1000);
		profilePage.clickView();
		profilePage.clickHeightAndWeight();
		profilePage.clickAddHeightAndWeight(); 
		/*
		 * System.out.println("Before add button"); if
		 * (profilePage.checkAddHeightAndWeight() == true) {
		 * profilePage.clickAddHeightAndWeight(); } else {
		 * profilePage.clickEditHeightAndWeight(); }
		 */
		profilePage.clickFT();
		profilePage.heightInFT();
		profilePage.heightInInch();
		profilePage.weightInKg();
		Thread.sleep(1000);
		profilePage.saveHeightAndWeight();

		Assert.assertEquals(profilePage.assertTC04(), true, "Test case 4 failed");
	}
}
