package datadriven;

import org.testng.annotations.Test;

import utility.BrowserFactory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class TestngTest {

	private static WebDriver driver;

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { 
				new Object[] { "testuser@yopmail.com",  "111111" },
				new Object[] { "testuser1@yopmail.com", "111111" },
				new Object[] { "testuser2@yopmail.com", "222222" } 
				};
	}

	@BeforeClass
	public void beforeClass() {
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get("http://www.davidjones.com.au");
		System.out.println("### SET UP BEFORE CLASS ###");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		System.out.println("### SET UP BEFORE CLASS ###");
	}
	
	@Test(dataProvider = "dp")
	public void test(String username, String password) {
		
		WebElement loginButton = driver.findElement(By.id("headerLogin"));

		// click an elemnet
		loginButton.click();

		WebElement userName = driver.findElement(By.name("logonId"));
		WebElement passWord = driver.findElement(By.name("logonPassword"));
		WebElement form = driver.findElement(By.id("Logon"));

		userName.sendKeys("abcdef");
		assertEquals("abcdef", userName.getAttribute("value"));

		// input text
		passWord.sendKeys("111111");

		// clear text
		userName.clear();
		assertEquals("", userName.getAttribute("value"));

		passWord.clear();

		userName.sendKeys(username);
		assertEquals(username, userName.getAttribute("value"));

		passWord.sendKeys(password);

		// submit
		form.submit();

		assertEquals("My Account", driver.getTitle());

		// logout
		driver.findElement(By.cssSelector("#user-cart > p > a")).click();
	}
}
