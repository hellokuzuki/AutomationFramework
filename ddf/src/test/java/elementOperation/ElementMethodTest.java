package elementOperation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.BrowserFactory;

public class ElementMethodTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = BrowserFactory.getBrowser("Chrome");
		System.out.println("### SET UP BEFORE CLASS ###");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("### SET UP EACH TEST ###");
		driver.get("http://www.davidjones.com.au");

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
	public void textClearTest() {
		WebElement loginButton = driver.findElement(By.id("headerLogin"));

		// click an elemnet
		loginButton.click();

		WebElement userName = driver.findElement(By.name("logonId"));
		WebElement passWord = driver.findElement(By.name("logonPassword"));
		WebElement form = driver.findElement(By.id("Logon"));

		userName.sendKeys("abcdef");
		assertEquals("abcdef", userName.getAttribute("value"));

		// input text
		passWord.sendKeys("111111");

		// clear text
		userName.clear();
		assertEquals("", userName.getAttribute("value"));

		passWord.clear();

		userName.sendKeys("testuser@yopmail.com");
		assertEquals("testuser@yopmail.com", userName.getAttribute("value"));

		passWord.sendKeys("111111");

		// submit
		form.submit();

		assertEquals("My Account", driver.getTitle());

		// logout
		driver.findElement(By.cssSelector("#user-cart > p > a")).click();

	}

	@Test
	public void getTextTest() {
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/a"));
		assertEquals("David Jones", logo.getText());

		// Get hidden text from element
		WebElement hidenText = driver.findElement(By.xpath("//*[@id=\"MiniCartFocusReceiver2\"]/p"));
		System.out.println(hidenText.getAttribute("innerText"));

		WebElement inner = driver.findElement(By.className("cart-empty-message"));
		assertEquals("Your shopping bag is empty.", inner.getAttribute("innerText"));
	}

	@Ignore
	@Test
	public void getCssValueTest() {
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]"));
		assertEquals("940px", logo.getCssValue("width"));

		WebElement span = driver.findElement(By.linkText("Sale"));
		System.out.println(span.getCssValue("color"));
	}

	@Test
	public void dropDownListTest() {

		WebElement loginButton = driver.findElement(By.id("headerLogin"));
		loginButton.click();

		WebElement userName = driver.findElement(By.name("logonId"));
		WebElement passWord = driver.findElement(By.name("logonPassword"));
		WebElement form = driver.findElement(By.id("Logon"));

		userName.sendKeys("testuser@yopmail.com");
		passWord.sendKeys("111111");

		form.submit();

		WebElement myAccount = driver.findElement(By.id("headerMyAccount"));
		myAccount.click();

		WebElement myPersonal = driver.findElement(By.id("personalInformation"));
		myPersonal.click();

		Select title = new Select(driver.findElement(By.name("personTitle")));

		assertFalse(title.isMultiple());

		assertEquals(6, title.getOptions().size());

		title.selectByVisibleText("DR");
		assertEquals("DR", title.getFirstSelectedOption().getText());

		title.selectByIndex(4);
		assertEquals("MISS", title.getFirstSelectedOption().getText());

		title.selectByValue("MRS");
		assertEquals("MRS", title.getFirstSelectedOption().getText());

		List<WebElement> ulist = driver.findElements(By.xpath("//*[@id=\"Register\"]/fieldset[3]/ul/li[2]/ul/li"));

		for (WebElement list : ulist) {
			System.out.println(list.getText());
		}

		// logout
		driver.findElement(By.cssSelector("#user-cart > p > a")).click();
	}

	@Test
	public void checkingSelectedOptionTest() {

		WebElement loginButton = driver.findElement(By.id("headerLogin"));
		loginButton.click();

		WebElement userName = driver.findElement(By.name("logonId"));
		WebElement passWord = driver.findElement(By.name("logonPassword"));
		WebElement form = driver.findElement(By.id("Logon"));

		userName.sendKeys("testuser@yopmail.com");
		passWord.sendKeys("111111");

		form.submit();

		WebElement myAccount = driver.findElement(By.id("headerMyAccount"));
		myAccount.click();

		WebElement myPersonal = driver.findElement(By.id("personalInformation"));
		myPersonal.click();

		Select title = new Select(driver.findElement(By.name("personTitle")));
		assertEquals(6, title.getOptions().size());

		List<String> expectList = Arrays.asList("SELECT", "MR", "MS", "MRS", "MISS", "DR");

		List<String> actualList = new ArrayList<String>();

		for (WebElement options : title.getOptions()) {
			actualList.add(options.getText());
		}

		assertArrayEquals(expectList.toArray(), actualList.toArray());

		// logout
		driver.findElement(By.cssSelector("#user-cart > p > a")).click();

	}

	@Test
	public void radioButtonAndGroupTest() {
		driver.get("http://cookbook.seleniumacademy.com/Config.html");

		WebElement petrol = driver.findElement(By.xpath("//*[@id=\"tabs-1\"]/p[2]/input[1]"));

		if (!petrol.isSelected()) {
			petrol.click();
		}

		assertTrue(petrol.isSelected());

		List<WebElement> radios = driver.findElements(By.name("fuel_type"));

		for (WebElement radio : radios) {
			if (radio.getAttribute("value").equals("Diesel")) {
				if (!radio.isSelected()) {
					radio.click();
				}
				assertTrue(radio.isSelected());
				break;
			}
		}
	}

	@Test
	public void checkBoxsTest() {
		WebElement loginButton = driver.findElement(By.id("headerLogin"));
		loginButton.click();

		WebElement userName = driver.findElement(By.name("logonId"));
		WebElement passWord = driver.findElement(By.name("logonPassword"));
		WebElement form = driver.findElement(By.id("Logon"));

		userName.sendKeys("testuser@yopmail.com");
		passWord.sendKeys("111111");

		form.submit();

		WebElement myAccount = driver.findElement(By.id("headerMyAccount"));
		myAccount.click();

		WebElement myPersonal = driver.findElement(By.id("personalInformation"));
		myPersonal.click();

		List<WebElement> checkboxes = driver.findElements(By.xpath("//ul[@class='checkbox checkbox-list']/li/label"));
		List<WebElement> inputs = driver.findElements(By.xpath("//ul[@class='checkbox checkbox-list']/li/input"));
		
		for (WebElement check : checkboxes) {
			if (check.getAttribute("class").equals("checked")) {
				check.click();
			}
		}
		
		for (WebElement input : inputs) {
			assertFalse(input.isSelected());
		}

		// logout
		driver.findElement(By.cssSelector("#user-cart > p > a")).click();

	}

	
	@Test
	public void webTableTest() {
		driver.get("http://cookbook.seleniumacademy.com/Locators.html");

		WebElement simpleTable = driver.findElement(By.id("items"));

		List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));

		assertEquals(3, rows.size());

		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				System.out.println(col.getText() + "\t");
			}
			System.out.println();

		}

	}

}
