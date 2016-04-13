package selniumAPI;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserFactory;

public class ExecutingJavascriptTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		driver = BrowserFactory.getBrowser("Chrome");
		System.out.println("### SET UP BEFORE CLASS ###");
	}

	@Before
	public void setUp() throws Exception {

		 driver.get("http://www.davidjones.com.au");
//		driver.get("http://www.google.com");
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
	public void testContextMenu() {

		 JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 String title = (String) js.executeScript("return document.title");
		 
		 String text = "Shop Online at David Jones - Women's Fashion - Beauty -Shoes & Accessories - Men's Fashion - Children's Fashion - Home";
		
		 assertEquals(title,text);
		
		 Long links = (Long) js.executeScript("var links = document.getElementsByTagName('A'); return links.length");

		 assertEquals("672",links.toString());
		 
		 js.executeScript("alert('hello world');");
		 
		 WebDriverWait wait = new WebDriverWait(driver,10);
		 
		 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		 
		 assertEquals(alert.getText(),"hello world");
		 
		 alert.accept();

	}

}
