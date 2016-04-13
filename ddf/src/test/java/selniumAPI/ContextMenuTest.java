package selniumAPI;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserFactory;

public class ContextMenuTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		driver = BrowserFactory.getBrowser("Chrome");
		System.out.println("### SET UP BEFORE CLASS ###");
	}

	@Before
	public void setUp() throws Exception {

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
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
		
		WebElement clickMeBtn = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
		
//		WebElement contextEditMenu = driver.findElement(By.cssSelector("li.context-menu-icon-edit"));
//		
//		WebElement contextCutMenu = driver.findElement(By.cssSelector("li.context-menu-icon-cut"));
		
		WebElement contextCopyMenu = driver.findElement(By.cssSelector("li.context-menu-icon-copy"));
		
//		WebElement contextPasteMenu = driver.findElement(By.cssSelector("li.context-menu-icon-paste"));
//		
//		WebElement contextDeleteMenu = driver.findElement(By.cssSelector("li.context-menu-icon-paste"));
		
		Actions builder = new Actions(driver);
		
		builder.contextClick(clickMeBtn).moveToElement(contextCopyMenu).click().build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver,0);
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		assertEquals("clicked: copy", alert.getText());
		
		alert.dismiss();
		
	}

}
