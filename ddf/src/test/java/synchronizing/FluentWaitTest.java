package synchronizing;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import utility.BrowserFactory;

public class FluentWaitTest {

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
	public void testIgnoreNoSuchElementException() {
		driver.findElement(By.xpath("//*[@id=\"header_links\"]/ul/li[3]/a")).click();
		
		try {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(5, TimeUnit.SECONDS)
			       .pollingEvery(2, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class)
			       .ignoring(TimeoutException.class);
		
		wait.until(
				new Function<WebDriver, WebElement>(){
					public WebElement apply(WebDriver d){
						return d.findElement(By.id("invalid"));
					}
				}
				);
		} catch (NoSuchElementException e) {
			System.out.println("No Such element exception.");
		} catch (TimeoutException d) {
			System.out.println("Timeout exception.");
		}finally {
			System.out.println("Finally.");
			driver.quit();
		}
	}
	
	@Test
	public void testNoSuchElementException() {
		driver.findElement(By.xpath("//*[@id=\"header_links\"]/ul/li[3]/a")).click();
		
		try {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(5, TimeUnit.SECONDS)
			       .pollingEvery(2, TimeUnit.SECONDS)
//			       .ignoring(NoSuchElementException.class)
			       .ignoring(TimeoutException.class);
		
		wait.until(
				new Function<WebDriver, WebElement>(){
					public WebElement apply(WebDriver d){
						return d.findElement(By.id("invalid"));
					}
				}
				);
		} catch (NoSuchElementException e) {
			System.out.println("No Such element exception.");
		} catch (TimeoutException d) {
			System.out.println("Timeout exception.");
		}finally {
			System.out.println("Finally.");
			driver.quit();
		}
	}

}
