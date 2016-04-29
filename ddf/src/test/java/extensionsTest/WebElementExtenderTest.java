package extensionsTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import extensions.WebElementExtender;
import utility.BrowserFactory;

public class WebElementExtenderTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		driver = BrowserFactory.getBrowser("Chrome");
		System.out.println("### SET UP BEFORE CLASS ###");
	}

	@Before
	public void setUp() throws Exception {

		driver.get(
				"https://shop.davidjones.com.au/webapp/wcs/stores/servlet/LogonForm?catalogId=10051&myAcctMain=1&langId=-1&storeId=10051");
		System.out.println("### SET UP EACH TEST ###");
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

		WebElement loginId = driver.findElement(By.id("WC_AccountDisplay_FormInput_logonId_In_Logon_1"));
		WebElement loginPw = driver.findElement(By.id("WC_AccountDisplay_FormInput_logonPassword_In_Logon_1"));


		WebElementExtender.setAttribute(loginId, "value", "testuser@yopmail.com");

		WebElementExtender.setAttribute(loginPw, "value", "111111");

		driver.findElement(By.xpath("//*[@id=\"Logon\"]/fieldset/ul/li[5]/div/input")).click();

		assertEquals("My Account", driver.getTitle());

		driver.quit();
	}

}
