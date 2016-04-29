package extensionsTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.BrowserFactory;
import utils.ObjectMap;

public class ObjectMapTest {

	private static WebDriver driver;
	private ObjectMap map;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		driver = BrowserFactory.getBrowser("Chrome");
		driver.get("https://shop.davidjones.com.au/webapp/wcs/stores/servlet/LogonForm?catalogId=10051&myAcctMain=1&langId=-1&storeId=10051");
		System.out.println("### SET UP BEFORE CLASS ###");
	}

	@Before
	public void setUp() throws Exception {
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
		map = new ObjectMap("./src/main/java/objectmap.properties");
		
		WebElement login = driver.findElement(map.getLocator("login_field"));
		WebElement pw = driver.findElement(map.getLocator("password_filed"));
		WebElement submit = driver.findElement(map.getLocator("submit_field"));
		
		login.sendKeys("testuser@yopmail.com");
		
		pw.sendKeys("111111");
		
		submit.click();
		
		assertEquals("My Account", driver.getTitle());
		
	}

}
