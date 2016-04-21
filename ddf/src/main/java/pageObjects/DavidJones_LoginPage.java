package pageObjects;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utility.BrowserFactory;

public class DavidJones_LoginPage extends LoadableComponent<DavidJones_LoginPage>{

	private WebDriver driver;
	private String url = "https://shop.davidjones.com.au/webapp/wcs/stores/servlet/LogonForm?catalogId=10051&myAcctMain=1&langId=-1&storeId=10051";

	// Constructor
	public DavidJones_LoginPage (){
		this.driver = BrowserFactory.getBrowser("Chrome");
		PageFactory.initElements(driver, this);
	}

	// List Up all the element to be tested.

	private WebElement logonId;

	private WebElement logonPassword;
	
	@FindBy(xpath = "//*[@id=\"Logon\"]/fieldset/ul/li[3]/label")
	private WebElement labelRemeberMe;

	@FindBy(xpath = "//*[@id=\"Logon\"]/fieldset/ul/li[5]/div/input")
	private static WebElement btnSignIn;


	// Click on Element methods
	public void InputLoginId(String username) {
		logonId.clear();
		logonId.sendKeys(username);
	}

	public void InputLogonPassword(String password) {
		logonPassword.clear();
		logonPassword.sendKeys(password);
	}

	public void clickbtnSignIn() {
		btnSignIn.click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void close(){
		this.driver.quit();
	}

	@Override
	protected void isLoaded() throws Error {
		assertEquals("Sign In",driver.getTitle());
	}

	@Override
	protected void load() {
		this.driver.get(url);
	}

}
