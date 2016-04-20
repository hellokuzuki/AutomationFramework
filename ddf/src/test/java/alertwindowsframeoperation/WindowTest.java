package alertwindowsframeoperation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import utility.BrowserFactory;

public class WindowTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		driver = BrowserFactory.getBrowser("Chrome");
		System.out.println("### SET UP BEFORE CLASS ###");
	}

	@Before
	public void setUp() throws Exception {

		 driver.get("http://cookbook.seleniumacademy.com/Config.html");
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
	
	@Ignore
	@Test
	public void test() {
		
		String parentHandle = driver.getWindowHandle();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String script = 
				"var myWindow = window.open(\"\", \"myWindow\", \"width=200,height=100\");" +
				"myWindow.document.write(\"<HTML><title>testtitle</title>text</HTML>\");";
		
		js.executeScript(script);
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			System.out.println("1111");
			// Switch to the myWindow using name
			driver.switchTo().window("myWindow");

			try {
				System.out.println("2222");
				// Check the driver context is in Help window
//				System.out.println(driver.getTitle());
				assertEquals("testtitle", "testtitle");
			} finally {
				System.out.println("3333");
				// Close the Help window
				driver.close();
			}
		} finally {
			System.out.println("4444");
			// Switch to the parent browser window
			driver.switchTo().window(parentHandle);
			System.out.println(driver.getTitle());
		}
		
	}
	
	@Test
	public void test1() {
		// Store WindowHandle of parent browser window
		String parentWindowId = driver.getWindowHandle();

		// Clicking Help button will open Help Page in a new child window
		driver.findElement(By.id("helpbutton")).click();

		try {
			// Switch to the Help window using name
			driver.switchTo().window("HelpWindow");

			try {
				// Check the driver context is in Help window
				assertEquals("Help", driver.getTitle());
			} finally {
				// Close the Help window
				driver.close();
			}
		} finally {
			// Switch to the parent browser window
			driver.switchTo().window(parentWindowId);
		}
		// Check driver context is in parent browser window
		assertEquals("Build my Car - Configuration", driver.getTitle());
	}
	
	@Test
	public void testWindowUsingTitle() {
		// Store WindowHandle of parent browser window
		String parentWindowId = driver.getWindowHandle();

		// Clicking Visit Us Button will open Visit Us Page in a new child
		// window
		driver.findElement(By.id("visitbutton")).click();

		// Get Handles of all the open windows
		// iterate through list and check if tile of
		// each window matches with expected window title
		try {
			for (String windowId : driver.getWindowHandles()) {
				String title = driver.switchTo().window(windowId).getTitle();
				if (title.equals("Visit Us")) {
					assertEquals("Visit Us", driver.getTitle());
					// Close the Visit Us window
					driver.close();
					break;
				}
			}
		} finally {
			// Switch to the parent browser window
			driver.switchTo().window(parentWindowId);
		}

		// Check driver context is in parent browser window
		assertEquals("Build my Car - Configuration", driver.getTitle());
	}
	

}
