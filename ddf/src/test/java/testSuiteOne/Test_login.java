package testSuiteOne;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.Constants;
import utility.BrowserFactory;
import pageObjects.Home_Page;
import pageObjects.Login_Page;

public class Test_Login {

	private static WebDriver driver;

	/**
	 * Run before the first test method in the current class is invoked. 
	 */
	@BeforeClass
	public void setup() {
		
		driver = BrowserFactory.getBrowser("Chrome");
	}

	/**
	 * Method as supplying data for a test method. 
	 */
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
		return new Object[][] { { "octone", "wgzOMlb5klEz" }, { "octtwo", "HIJiyugb0CSj" } };
	}

	/**
	 * Marks a class or a method as part of the test. 
	 */
	@Test(dataProvider = "Authentication")
	public void test(String sUsername, String sPassword) {

		Home_Page homepage = new Home_Page(driver);

		Login_Page loginpage = new Login_Page(driver);

		//Go to home page.
		homepage.goto_HomePage(driver, Constants.URL);
		
		//Click on login button of home page.
		homepage.login_click();
		
		//Perform login process.
		loginpage.login_action(sUsername, sPassword);
		
		//Click on Logout button of home page.
		homepage.logout_click();

	}

	/**
	 * run after all the test methods in the current class have been run. 
	 */
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
