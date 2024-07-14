package ecommerce.demo.Project1_ECommerce;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Amazon_ValidLogin_Page {

	WebDriver driver;
	
	@FindBy(xpath = "//a[@data-nav-role='signin']")
	WebElement accountAndList;
	
	public void accountAndList(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(accountAndList).perform();
	}

	@FindBy(xpath = "(//span[@class='nav-action-inner'])[1]")
	WebElement signInButton;
	
	public void signIn() {
		signInButton.click();
	}
	
	@FindBy(name = "email")
	WebElement emailId;
	
	public void emailID() {
		emailId.sendKeys("paloskr26@gmail.com",Keys.ENTER);
	}
	
	@FindBy(css = "#ap_password")
	WebElement password;
	
	public void password() {
		password.sendKeys("paloskr@123",Keys.ENTER);
	}
	
	
	public Amazon_ValidLogin_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
}
