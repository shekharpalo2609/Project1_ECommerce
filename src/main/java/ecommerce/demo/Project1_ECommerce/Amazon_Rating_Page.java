package ecommerce.demo.Project1_ECommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Rating_Page {

	WebDriver driver;

	public Amazon_Rating_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

}
