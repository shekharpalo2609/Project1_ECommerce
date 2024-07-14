package ecommerce.demo.Project1_ECommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Amazon_Search_Result_Page {

	WebDriver driver;

	@FindBy(xpath = "(//a[@data-routing='off']/span[@class='a-size-base a-color-base'])[4]")
	WebElement mensSneakerCategory;
	
	public void selectCategory() {
		mensSneakerCategory.click();
	}
	
	@FindBy(xpath = "(//input[@aria-valuetext='₹31,000+'])")
	WebElement maxPrice;
	
	@FindBy(xpath = "(//input[@aria-valuetext='₹10,000'])")
	WebElement maxPriceBudget;
	
	public void selectPriceRange(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(maxPrice, maxPriceBudget).perform();
	}
	
	@FindBy(xpath = "//span[normalize-space()='Mens Sx0675g Walking Shoe']")
	WebElement selectShoe;
	
	public void selectProduct() {
		selectShoe.click();
	}
	
	@FindBy(name = "s")
	WebElement sort;
	
	public void selectRelevance() {
		Select selectRelevance = new Select(sort);
		selectRelevance.selectByValue("date-desc-rank");
	}
	
	public void selectPrice() {
		Select selectPrice = new Select(sort);
		selectPrice.selectByVisibleText("Price: Low to High"); 
	}
	
	public void selectRating() {
		Select selectRating = new Select(sort);
		selectRating.selectByVisibleText("Avg. Customer Review"); 
	}
	
	@FindBy(xpath = "//h2[normalize-space()='Results for you']")
	WebElement resultsForYou;

	public boolean assertTC06() {
		return resultsForYou.isDisplayed();
	}
	
	public boolean assertTC05() {
		return resultsForYou.isDisplayed();
	}
	
	public Amazon_Search_Result_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

}
