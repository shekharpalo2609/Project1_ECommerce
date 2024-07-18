package ecommerce.demo.Project1_ECommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Profile_Page {

	WebDriver driver;

	@FindBy(linkText = "View")
	WebElement viewLink;

	public void clickView() {
		viewLink.click();
	}

	@FindBy(xpath = "//div[normalize-space()='Height and weight']")
	WebElement heightAndWeight;

	public void clickHeightAndWeight() {
		heightAndWeight.click();
	}

	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement addHeightAndWeightButton;

	public boolean checkAddHeightAndWeight() {
		return addHeightAndWeightButton.isDisplayed();
	}

	public void clickAddHeightAndWeight() {
		addHeightAndWeightButton.click();
	}

	@FindBy(xpath = "//button[normalize-space()='Edit']")
	WebElement editHeightAndWeight;

	public void clickEditHeightAndWeight() {
		editHeightAndWeight.click();
	}

	@FindBy(xpath = "//button[normalize-space()='ft']")
	WebElement selectFT;

	public void clickFT() {
		selectFT.click();
	}

	@FindBy(xpath = "(//input[@class='number-input-box'])[1]")
	WebElement heightInFT;

	public void heightInFT() {
		heightInFT.sendKeys("5");
	}

	@FindBy(xpath = "(//input[@class='number-input-box'])[2]")
	WebElement heightInInch;

	public void heightInInch() {
		heightInInch.sendKeys("7");
	}

	@FindBy(xpath = "(//input[@class='number-input-box'])[3]")
	WebElement weightInKg;

	public void weightInKg() {
		weightInKg.sendKeys("65");
	}

	// @FindBy(className = "a-button a-button-normal a-button-primary button")
	@FindBy(xpath = "//span[@class='a-button a-button-normal a-button-primary button']//input[@type='submit']")
	WebElement saveButton;

	public void saveHeightAndWeight() {
		saveButton.click();
	}

	@FindBy(xpath = "//div[normalize-space()='Your Profiles']")
	WebElement yourProfile;

	public boolean assertTC04() {
		return yourProfile.isDisplayed();
	}

	public Amazon_Profile_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

}
