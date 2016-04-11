package locators;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserFactory;

public class AlertFrameWindowsTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.out.println("### SET UP ###");
		driver = BrowserFactory.getBrowser("Chrome");
		// driver.get("http://www.davidjones.com.au");
		driver.get("http://cookbook.seleniumacademy.com/Alerts.html");

	}

	@AfterClass
	public static void tearDown() throws Exception {
		// driver.close();
		driver.quit();
		System.out.println("### TEAR DOWN ###");
	}

	@Test
	public void testAlert() {
		driver.findElement(By.id("simple")).click();

		new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();

		assertEquals("Hello! I am an alert box!", alert.getText());

		alert.accept();
	}

	@Test
	public void testConfrimAccept() {
		driver.findElement(By.id("confirm")).click();

		new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();

		alert.accept();

		assertEquals("You Accepted Alert!", driver.findElement(By.id("demo")).getText());
	}
	
	@Test
	public void testConfrimDismiss() {
		driver.findElement(By.id("confirm")).click();

		new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();

		alert.dismiss();

		assertEquals("You Dismissed Alert!", driver.findElement(By.id("demo")).getText());
	}
	
	@Test
	public void testPromptAccept(){
		driver.findElement(By.id("prompt")).click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("255");
		alert.accept();
		assertEquals("Hello 255! How are you today?", driver.findElement(By.id("prompt_demo")).getText());
		
	}
}
