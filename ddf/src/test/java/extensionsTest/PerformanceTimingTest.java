package extensionsTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import extensions.PerformanceTiming;
import utility.BrowserFactory;

public class PerformanceTimingTest {

	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get("https://www.davidjones.com.au");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void test() throws Exception {
		
		PerformanceTiming timing = new PerformanceTiming(driver);
		
		System.out.println("Page Load time is " + timing.getPageLoadingTime() + " Seconds.");
	}
	

}
