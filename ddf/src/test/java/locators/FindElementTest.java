	package locators;

	import static org.junit.Assert.*;

import java.util.Arrays;
//	import java.util.Arrays;
	import java.util.List;

	import org.junit.AfterClass;
	import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	import utility.BrowserFactory;

	public class FindElementTest {

		private static WebDriver driver;

		@BeforeClass
		public static void setUp() throws Exception {
			System.out.println("### SET UP ###");
			driver = BrowserFactory.getBrowser("Chrome");
			driver.get("http://www.davidjones.com.au");

		}

		@AfterClass
		public static void tearDown() throws Exception {
			driver.close();
			driver.quit();
			System.out.println("### TEAR DOWN ###");
		}

		@Test
		public void testFindElementByID() {
			WebElement navText = driver.findElement(By.id("topCat_26551"));
			assertEquals("Women", navText.getText());
		}

		@Test
		public void testFindElementByName() {
			WebElement searchBox = driver.findElement(By.name("w"));
			assertEquals("Search David Jones online", searchBox.getAttribute("placeholder"));
		}

		@Test
		public void testFindElementByClass() {
			WebElement logoText = driver.findElement(By.className("logo"));
			assertEquals("David Jones", logoText.getText());
		}

		@Test
		public void testFindElements() {
			List<WebElement> naviTexts = driver.findElements(By.xpath("//*[@id=\"navigation\"]/div/ul/li"));

			for (WebElement content : naviTexts) {
				System.out.println("###" + content.getText());
			}
			assertEquals(12, naviTexts.size());
		}

		@Test
		public void testFindElementByLink() {
			WebElement link = driver.findElement(By.linkText("David Jones"));
			assertEquals("http://shop.davidjones.com.au/djs/en/davidjones", link.getAttribute("href"));
		}

		@Test
		public void testFindElementByTagName() {
			WebElement lists = driver.findElement(By.className("task-menu"));
			List<WebElement> li = lists.findElements(By.tagName("li"));
			assertEquals(4, li.size());
		}

		@Test
		public void testFindElementByXpath() {
//			WebElement signupButton = driver.findElement(By.xpath("//*[@id=\"headerLogin\"]"));
//			Error! Sign Up button id has the same id as Sign in button, should change the id of create an account to "headersignup"
//			assertEquals("Create an Account", signupButton.getText());
//			System.out.println("sign up location is " + signupButton.getLocation());
			WebElement signinButton = driver.findElement(By.xpath("//*[@id=\"headerLogin\"]"));
			assertEquals("Sign In", signinButton.getText());
			System.out.println("sign up location is " + signinButton.getLocation());
		}

		@Test
		public void testFindElementByCssSelector() {
			// WebElement signupButton =
			// driver.findElement(By.xpath("//*[@id=\"headerLogin\"]"));
			// Error! Sign Up button id has the same id as Sign in button, should
			// change the id of create an account to "headersignup"
			// assertEquals("Create an Account", signupButton.getText());
			// System.out.println("sign up location is " +
			// signupButton.getLocation());
			WebElement signinButton = driver.findElement(By.cssSelector("#headerLogin"));
			assertEquals("Sign In", signinButton.getText());

		}
		
		@Test
		public void testFindElementUsingText() {
			WebElement text = driver.findElement(By.xpath("//*[@id=\"shoppingCartBar\"][contains(.,'Shopping')]"));
			assertEquals("Shopping bag (0)", text.getText());

		}
		
		@Test
		public void testFindElementAdvancedCssSelector() {
			WebElement search = driver.findElement(By.xpath("//*[@id=\"SimpleSearchForm_SearchTerm\"]"));
			search.click();
			search.sendKeys("abcde");
			WebElement focus = driver.findElement(By.cssSelector("input:focus"));
			assertEquals("abcde", focus.getAttribute("value"));
		}
		
		@Ignore
		@Test
		public void testFindElementUsingJQuerySelector() {
			driver.get("http://cookbook.seleniumacademy.com/Locators.html");
			
			List<String> checked = Arrays.asList("user128_admin", "user220_browser");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			@SuppressWarnings("unchecked")
			List<WebElement> elements = (List<WebElement>) js.executeScript("return jQuery.find(':unchecked')");
			assertEquals(2, elements.size());
			
			for(WebElement element : elements){
				assertTrue(checked.contains(element.getAttribute("id")));
				System.out.println(element.getAttribute("id").toString());
			}
		}

	}
