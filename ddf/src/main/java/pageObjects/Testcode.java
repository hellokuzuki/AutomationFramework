package pageObjects;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.Constants;
import utility.BrowserFactory;

public class Testcode {
	private static WebDriver driver = BrowserFactory.getBrowser("Chrome");
	
	//Define DateProvider.
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
		return new Object[][] { {"octone", "wgzOMlb5klEz"}, {"octtwo", "HIJiyugb0CSj"}};
	}
	
	@Test(dataProvider = "Authentication")
	public void test(String sUsername, String sPassword) {
		
//		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(Constants.URL);
	    driver.findElement(By.xpath(Home_Page.xpath_Login_Btn)).click();
	    driver.findElement(By.id(Login_Page.id_Id_TextField)).sendKeys(sUsername);
	    driver.findElement(By.id(Login_Page.id_Pwd_TextField)).sendKeys(sPassword);
	    driver.findElement(By.id(Login_Page.id_Login_Btn)).click();
	    driver.findElement(By.xpath(Home_Page.xpath_Logout_Btn)).click();
//	    driver.quit();
	}
	
	 
}
