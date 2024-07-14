package ecommerce.demo.Project1_ECommerce;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Home_Page {

	static WebDriver driver;

	@FindBy(xpath = "//a[@data-nav-role='signin']")
	WebElement accountAndList;

	public void accountAndList(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(accountAndList).perform();
	}

	@FindBy(xpath = "(//a[@class='nav-a'][normalize-space()='Start here.'])[1]")
	WebElement startHere;

	public void register() {
		startHere.click();
	}
	
	@FindBy(xpath = "(//span[@class='nav-action-inner'])[1]")
	WebElement signInButton;
	
	public void signIn() {
		signInButton.click();
	}

	@FindBy(xpath = "//span[.='Manage Profiles']")
	WebElement manageProfile;

	public void manageProfile() {
		manageProfile.click();
	}

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchTextBox;

	public void searchProduct() {
		searchTextBox.sendKeys("shoe", Keys.ENTER);
	}

	@FindBy(xpath = "//a[@id='nav-orders']")
	WebElement returnsAndOrders;

	public void returnsAndOrders() {
		returnsAndOrders.click();
	}

	@FindBy(xpath = "//a[@id='nav-logo-sprites']")
	WebElement amazonLogo;
	
	public boolean assertTC02() {
		return amazonLogo.isDisplayed();
	}
	
	public Amazon_Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

}
