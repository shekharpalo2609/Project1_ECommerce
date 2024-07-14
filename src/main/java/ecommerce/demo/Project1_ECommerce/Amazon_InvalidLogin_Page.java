package ecommerce.demo.Project1_ECommerce;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_InvalidLogin_Page {

	WebDriver driver;
	
	@FindBy(css = "[type='email']")
	WebElement emailId;
	
	public void emailID() {
		emailId.sendKeys("paloskr26@gmail.com",Keys.ENTER);
	}
	
	@FindBy(css = "[type='password']")
	WebElement password;
	
	public void password() {
		password.sendKeys("shekhar@123",Keys.ENTER);
	}
	
	@FindBy(xpath = "//h4[normalize-space()='There was a problem']")
	WebElement alertMessage;
	
	public boolean assertTC03() {
		return alertMessage.isDisplayed();
	}


	public Amazon_InvalidLogin_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

}
