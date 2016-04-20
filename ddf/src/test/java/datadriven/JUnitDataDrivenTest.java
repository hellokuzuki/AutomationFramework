package datadriven;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.BrowserFactory;

@RunWith(Parameterized.class)
public class JUnitDataDrivenTest {
	
	private static WebDriver driver;
	private String username;
	private String password;
	
	public JUnitDataDrivenTest (String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Parameters
	public static List<String[]> testData(){
		return Arrays.asList(new String[][] {
			{"testuser@yopmail.com", "111111"},
			{"testuser1@yopmail.com", "111111"},
			{"testuser2@yopmail.com", "222222"}
			});
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = BrowserFactory.getBrowser("Chrome");
		System.out.println("### SET UP BEFORE CLASS ###");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("### SET UP EACH TEST ###");
		driver.get("http://www.davidjones.com.au");

	}

	@After
	public void tearDown() throws Exception {
		System.out.println("### TEAR DOWN EACH TEST ###");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
		System.out.println("### TEAR DOWN AFTER CLASS###");
	}


	@Test
	public void test() {
		
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
