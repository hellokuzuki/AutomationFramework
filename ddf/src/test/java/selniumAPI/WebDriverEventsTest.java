package selniumAPI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utility.BrowserFactory;
import utils.Listener;

public class WebDriverEventsTest {

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
	public void test() {
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		
		Listener myListener = new Listener();
		
		eventDriver.register(myListener);
		
		eventDriver.get("http://www.google.com");
	}

}
