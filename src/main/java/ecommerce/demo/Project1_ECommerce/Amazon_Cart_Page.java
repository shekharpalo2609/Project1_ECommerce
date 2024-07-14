package ecommerce.demo.Project1_ECommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Amazon_Cart_Page {

	WebDriver driver;
	
	@FindBy(css = "[name='quantityBox']")
	WebElement quantityTextField;
	
	public void editQuantity() {
		quantityTextField.clear();
		quantityTextField.sendKeys("5");
	}
	
	@FindBy(css = "[data-action='update']")
	WebElement quantityUpdateButton;
	
	public void updateQuantity() {
		quantityUpdateButton.click();
	}
	
	@FindBy(name = "quantity")
	WebElement selectProductQuantity;
	
	public void selectQuantityFromDropdown() {
		Select selectQuantity = new Select(selectProductQuantity);
		selectQuantity.selectByValue("3");
	}
	
	@FindBy(css = "[value='Delete']")
	WebElement deleteProductButton;
	
	public void deleteProductFromCart() {
		deleteProductButton.click();
	}
	
	@FindBy(name = "proceedToRetailCheckout")
	WebElement proceedToBuyButton;
	
	public void proceedToBuy() {
		proceedToBuyButton.click();
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Your Amazon Cart is empty.']")
	WebElement emptyCartTextMsg;
	
	public boolean assertTC10() {
		return emptyCartTextMsg.isDisplayed();
	}

	public Amazon_Cart_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

}
