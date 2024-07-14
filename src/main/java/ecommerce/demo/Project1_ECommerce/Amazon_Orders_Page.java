package ecommerce.demo.Project1_ECommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Amazon_Orders_Page {

	WebDriver driver;
	
	@FindBy(name ="timeFilter")
	WebElement selectOrderPalcedDate;
	
	public void orderPalcedDate() {
		Select selectOrderDate = new Select(selectOrderPalcedDate);
		selectOrderDate.selectByValue("year-2024");
	}

	@FindBy(xpath ="(//a[@id='Write-a-product-review_2'])[1]")
	WebElement productReviewButton;
	
	public void productReview() {
		productReviewButton.click();
	}

	@FindBy(css ="[alt='select to rate item five star.']")
	WebElement fiveStar;
	
	public void rateFiveStar() {
		fiveStar.click();
	}
	
	@FindBy(xpath ="//span[contains(text(),'Clear')]")
	WebElement clearRatingButton;
	
	public void clearRating() {
		clearRatingButton.click();
	}

	@FindBy(xpath ="//h3[normalize-space()='Overall rating']")
	WebElement createReviewTextMsg;
	
	public boolean assertTC14() {
		return createReviewTextMsg.isDisplayed();
	}
	
	public Amazon_Orders_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
}
