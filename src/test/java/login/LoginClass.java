package login;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.chrome.ChromeDriver;

import amazon.listener.ListenerClass;
import ddt.packages.DDT_File;
import ecommerce.demo.Project1_ECommerce.Amazon_ValidLogin_Page;

public class LoginClass extends ListenerClass {
	
	public void amazonLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
//		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	}
		public void amazonLogin() throws EncryptedDocumentException, IOException {
		DDT_File file = new DDT_File();
		file.dataFetching();
		Amazon_ValidLogin_Page validLogin = new Amazon_ValidLogin_Page(driver);
		validLogin.accountAndList(driver);
		validLogin.signIn();
		validLogin.emailID();
		validLogin.password();
		
		if(driver.getTitle().equals("Authentication required")) {
			driver.navigate().back();
			driver.navigate().back();
			driver.navigate().refresh();
			validLogin.emailID();
			validLogin.password();
		}
	}
}