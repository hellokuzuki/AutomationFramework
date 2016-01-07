package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Home_Page {
	
	public static WebDriver driver;

	/**
	 * Login button xpath.
	 */
	@FindBy(xpath = ".//*[@id='account']/a")
	private WebElement login_Btn;
	
	/**
	 * Logout button xpath.
	 */
	@FindBy(xpath = ".//*[@id='account_logout']/a")
	private WebElement logout_Btn;

	/**
	 * Create a new instance of the Home_Page page class
     * and initialize any WebElement fields in it.
	 */
	public Home_Page(WebDriver driver) {
		Home_Page.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Go to Home page.
	 */
	public void goto_HomePage (WebDriver driver, String url) {
		driver.get(url);
	}
	
	/**
	 * Click on login button of home page.
	 */
	public void login_click () {
		login_Btn.click();
	}
	
	/**
	 * Click on logout button of home page.
	 */
	public void logout_click () {
		logout_Btn.click();
	}

	
}
