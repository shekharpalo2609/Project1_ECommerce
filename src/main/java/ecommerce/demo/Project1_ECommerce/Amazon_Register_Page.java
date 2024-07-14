package ecommerce.demo.Project1_ECommerce;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Register_Page {

	static WebDriver driver;
	
	@FindBy(css = "[type='email']")
	WebElement emailId;
	
	public void emailId() {
		emailId.sendKeys("abc123@gmail.com",Keys.ENTER);
	}
	
	@FindBy(css = "#ap_phone_number")
	WebElement mobileNo;
	
	public void mobileNo() {
		mobileNo.sendKeys("8850894037");
	}
	
	@FindBy(css = "#ap_customer_name")
	WebElement name;
	
	public void name() {
		name.sendKeys("Ashish kumar");
	}
	

	@FindBy(css = "#ap_password")
	WebElement password;
	
	public void password() {
		password.sendKeys("Ashish@123",Keys.ENTER);
	}

	
	public Amazon_Register_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

}
