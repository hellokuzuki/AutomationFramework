package locators;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserFactory;

public class SynchronizingTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.out.println("### SET UP ###");
		driver = BrowserFactory.getBrowser("Firefox");
		// driver.get("http://www.davidjones.com.au");
		driver.get("http://www.chemistwarehouse.com.au/");

	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
		System.out.println("### TEAR DOWN ###");
	}

	@Ignore
	@Test
	public void testImplicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		try {
			WebElement adBar = driver.findElement(By.className("pp_close"));
			adBar.click();
		} catch (Exception e) {
			System.out.println("???????" + e);
		}

	}

	@Ignore
	@Test
	public void testWithoutWait() {
		driver.manage().window().maximize();
		try {
			WebElement adBar = driver.findElement(By.className("pp_close"));
			adBar.click();
		} catch (Exception e) {
			System.out.println("???????" + e);
		}

	}

	@Ignore
	@Test
	public void testEmplicitWait() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("pp_close"))));
		driver.findElement(By.className("pp_close")).click();
		wait.until(ExpectedConditions.titleContains("Cheapest"));
		System.out.println(driver.getTitle());
		assertTrue(driver.getTitle().contains("Cheapest"));
	}

	@Test
	public void testCustomedExplicitWait() {
		driver.get("http://www.davidjones.com.au");
		try {
			WebElement contact = new WebDriverWait(driver,5)
					.until(new ExpectedCondition<WebElement>(){
						public WebElement apply(WebDriver d){
							return d.findElement(By.linkText("Contact us"));
						}
					});
			assertTrue(contact.getText().contains("Contact us"));
		} finally {
			driver.quit();

		}
	}

}
