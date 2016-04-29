package extensionsTest;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import extensions.WebElementExtender;
import utility.BrowserFactory;

public class ElementScreenshotTest {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get("http://www.davidjones.com.au");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testElementScreenShot() throws Exception {
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/a"));
		
		FileUtils.copyFile(WebElementExtender.captureElementPicture(logo), new File("./Resource/logo.png"));
	}

}
