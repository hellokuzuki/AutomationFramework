package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	public static WebDriver driver; 

	/**
	 * User Name input field
	 */
	@FindBy(id = "log")
	private WebElement id_Username_TextField;
	
	/**
	 * Password input field.
	 */
	@FindBy(id = "pwd")
	private WebElement id_Pwd_TextField;
	
	/**
	 * Login button input field.
	 */
	@FindBy(id = "login")
	private WebElement id_Login_Btn;
	
	/**
	 * Create a new instance of the Login_Page page class
     * and initialize any WebElement fields in it.
	 */
	public Login_Page(WebDriver driver) {
		Login_Page.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Login action.
	 */
	public void login_action(String username, String password) {
		id_Username_TextField.sendKeys(username);
		id_Pwd_TextField.sendKeys(password);
		id_Login_Btn.click();
	}
	
}
