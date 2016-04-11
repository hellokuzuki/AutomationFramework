package selniumAPI;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.BrowserFactory;

public class ElementStatusTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		driver = BrowserFactory.getBrowser("Chrome");
		System.out.println("### SET UP BEFORE CLASS ###");
	}

	@Before
	public void setUp() throws Exception {

		driver.get("http://www.davidjones.com.au");
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
	public void testElementStatus() {
		WebElement signup = driver.findElement(By.linkText("Create an Account"));
		signup.click();

		if (driver.findElement(By.xpath("//input[@name='sendMeEmail']")).isEnabled()) {
			if (!driver.findElement(By.xpath("//input[@name='sendMeEmail']")).isSelected()) {
				driver.findElement(By.xpath("//*[@id=\"WC_UserRegistrationAddForm_div_3\"]/fieldset/ul/li[2]/label"))
						.click();
			} else {
				System.out.println("Element is selected !!");
			}
		} else {
			fail("Element is disabled !!");
		}
	}

}
