package ecommerce.demo.Project1_ECommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Product_Page {

	WebDriver driver;

	@FindBy(xpath = "//span[normalize-space()='749']")
	WebElement productPrice;
	
	public Boolean checkProductPrice() {
		
		return productPrice.isDisplayed();
	}
	
	
	@FindBy(xpath = "//h2[normalize-space()='Customer reviews']")
	WebElement customerReviews;
	
	public Boolean checkCustomerReviews() {
		
		return customerReviews.isDisplayed();
	}
	
	@FindBy(xpath = "//h2[normalize-space()='Product description']")
	WebElement productDescription;
	
	public Boolean checkProductDescription() {
		
		return productDescription.isDisplayed();
	}
	
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addtoCartButton;
	
	public void addtoCart() {
		addtoCartButton.click();
	}
	
	@FindBy(xpath = "(//a[normalize-space()='Go to Cart'])[2]")
	WebElement goToCartButton;
	
	public void goToCart() {
		goToCartButton.click();
	}
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCartCartButton;
	
	public boolean assertTC07() {
		return addToCartCartButton.isDisplayed();
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Added to Cart']")
	WebElement addedToCartCartText;
	
	public boolean assertTC09() {
		return addedToCartCartText.isDisplayed();
	}
	
	public boolean assertTC15() {
		return addedToCartCartText.isDisplayed();
	}
	
	public Amazon_Product_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

}
