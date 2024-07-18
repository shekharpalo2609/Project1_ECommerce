package ecommerce.demo.Project1_ECommerce;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Amazon_PaymentMethods_Page {

	WebDriver driver;

	@FindBy(xpath = "//span[normalize-space()='Credit or debit card']")
	WebElement selectPaymentRadioButton;

	public void selectPayment() {
		selectPaymentRadioButton.click();
	}

	@FindBy(xpath = "(//a[@class='a-link-emphasis pmts-add-cc-default-trigger-link'])[1]")
	WebElement enterCardDetailLink;

	public void enterCardDetail() {
		enterCardDetailLink.click();
	}

	@FindBy(name = "ApxSecureIframe")
	WebElement iFrame;

	public void switchToIframe(WebDriver driver) {
		driver.switchTo().frame(iFrame);
	}

	@FindBy(name = "addCreditCardNumber")
	WebElement cardNumber;

	public void enterCardNumber() {
		cardNumber.sendKeys("5305620224857900");
	}

	@FindBy(name = "ppw-expirationDate_month")
	WebElement selectExpiryMonth;

	public void expiryMonth() {
		Select selectDate = new Select(selectExpiryMonth);
		selectDate.selectByValue("11");
	}

	@FindBy(name = "ppw-expirationDate_year")
	WebElement selectExpiryYear;

	public void expiryYear() {
		Select selectYear = new Select(selectExpiryYear);
		selectYear.selectByValue("2035");
	}

	@FindBy(name = "ppw-widgetEvent:AddCreditCardEvent")
	WebElement enterButton;

	public void saveCardDetails() {
		enterButton.click();
	}
	
	@FindBy(xpath = "//input[@name='addCreditCardVerificationNumber0']")
	WebElement cvvNumber;
	//div[@id='pp-dhDUdK-151']/input[@type='password']
	public void enterCvvNumber() {
		cvvNumber.sendKeys("111");
	}
	
	@FindBy(xpath = "//span[normalize-space()='State Bank of India Debit Card']")
	WebElement sbiCard;

	public void selectSBICard() {
		sbiCard.click();
	}
	
	@FindBy(xpath = "//span[normalize-space()='Visa']")
	WebElement indusIndCard;

	public void selectIndusindCard() {
		indusIndCard.click();
	}
	
	@FindBy(xpath = "//span[@class='a-text-bold'][normalize-space()='Net Banking']")
	WebElement netBanking;

	public void selectNetBanking() {
		netBanking.click();
	}
	
	@FindBy(xpath = "//span[normalize-space()='Other UPI Apps']")
	WebElement otherUPIApps;

	public void selectOtherUPIApps() {
		otherUPIApps.click();
	}
	
	@FindBy(xpath = "//span[@class='a-text-bold'][normalize-space()='EMI']")
	WebElement emiOption;

	public void selectEmiOption() {
		emiOption.click();
	}
	
	@FindBy(xpath = "(//div[@class='a-fixed-left-grid-inner']/div[@class='a-fixed-left-grid-col a-col-left'])[10]")
	WebElement codOption;

	public void selectCodOption() {
		codOption.click();
	}
	
	@FindBy(xpath = "//input[@placeholder='Enter Code']")
	WebElement coupunCode;

	public void enterCoupunCode() {
		coupunCode.sendKeys("coupun 20",Keys.ENTER);
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Checkout']")
	WebElement checkoutTextMsg;

	public boolean assertTc12() {
		return checkoutTextMsg.isDisplayed();
	}
	
	public boolean assertTc13() {
		return checkoutTextMsg.isDisplayed();
	}
	
	public Amazon_PaymentMethods_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

}
