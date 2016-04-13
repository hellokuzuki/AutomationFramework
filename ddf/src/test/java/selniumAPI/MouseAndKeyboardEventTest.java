package selniumAPI;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.BrowserFactory;

public class MouseAndKeyboardEventTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		driver = BrowserFactory.getBrowser("Chrome");
		System.out.println("### SET UP BEFORE CLASS ###");
	}

	@Before
	public void setUp() throws Exception {

		driver.get("http://component-showcase.icesoft.org/component-showcase/showcase.iface");
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

	@Ignore
	@Test
	public void testMouseAndKeyboard() {

		driver.findElement(By.linkText("Table")).click();
		
		driver.findElement(By.linkText("Row Selection")).click();
		
		driver.findElement(By.xpath("//label[@class='iceSelOneRb' and text()='Multiple']")).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"iceform:icepnltabset:0:employeeList\"]/tbody/tr"));
		
		System.out.println(rows.size());
		
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL)
				.click(rows.get(0))
				.click(rows.get(2))
				.click(rows.get(5))
				.keyUp(Keys.CONTROL)
				.build()
				.perform();
		
		List<WebElement> trs = driver.findElements(By.xpath("//*[@id=\"iceform:icepnltabset:0:selectedRows\"]/tbody/tr"));
		assertEquals(3, trs.size());
	}
	
	@Ignore
	@Test
	public void testMouseAndKeyboardWithShift(){

		driver.findElement(By.linkText("Table")).click();
		
		driver.findElement(By.linkText("Row Selection")).click();
		
		driver.findElement(By.xpath("//label[@class='iceSelOneRb' and text()='Multiple']")).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"iceform:icepnltabset:0:employeeList\"]/tbody/tr"));
		
		System.out.println(rows.size());
		
		Actions builder = new Actions(driver);
		builder.click(rows.get(0))
				.keyDown(Keys.SHIFT)
				.click(rows.get(2))
				.click(rows.get(5))
				.click(rows.get(6))
				.keyUp(Keys.SHIFT)
				.build()
				.perform();
		
//		WebElement tbody = driver.findElement(By.xpath("//*[@id=\"iceform:icepnltabset:0:selectedRows\"]/tbody"));
//		List<WebElement> trs = driver.findElements(By.xpath("//*[@id=\"iceform:icepnltabset:0:selectedRows\"]/tbody/tr"));
		
//		for (int i = 0; i <500 ; i++) {
//			driver.findElement(By.xpath("//label[@class='iceSelOneRb' and text()='Multiple']")).click();
//		}
//		
//		for (WebElement tr : trs) {
//			List<WebElement> tds = driver.findElements(By.xpath("//*[@id=\"iceform:icepnltabset:0:selectedRows\"]/tbody/tr/td"));
//			for (WebElement td : tds) {
//			}
//		}
//		assertEquals(4, trs.size());
	}
}
