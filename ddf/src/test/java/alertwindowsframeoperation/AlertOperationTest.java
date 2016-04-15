package alertwindowsframeoperation;

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

public class AlertOperationTest {

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
	public void testAlertBox() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("alert('test alert');");
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(alert.getText(),"test alert");
		
		alert.accept();
	}
	
	@Test
	public void testConfirmBox() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("confirm('test alert');");
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(alert.getText(),"test alert");
		
		alert.dismiss();
		
	}
	
	@Test
	public void testPromptBox() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("prompt('test alert','mark');");
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("test user #1");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(alert.getText(),"test alert");
		
		alert.accept();
		
	}

}
