package locators;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserFactory;

public class ContextMenuTest {

	private static WebDriver driver;

	@BeforeClass
	public static void Setup() {
		System.out.println("### SET UP ###");
		driver = BrowserFactory.getBrowser("Firefox");
		driver.get("http://medialize.github.io/jQuery-contextMenu/demo.html");
	}

	@Test
	public void testContextMenu() throws InterruptedException {
		WebElement clickButton = driver
				.findElement(By.cssSelector("body > div.wy-grid-for-nav > section > div > div > div > p > span"));
		WebElement copyButton = driver.findElement(By.xpath("/html/body/ul/li[3]"));

		try {
			Actions action = new Actions(driver);
			Thread.sleep(3000);
			action.contextClick(clickButton).moveToElement(copyButton).click().perform();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		assertEquals("clicked: copy", alert.getText());
		
		alert.dismiss();
		
		Thread.sleep(5000);

	}
	
	@Test
	public void testContextMenuByAccessKeys() throws InterruptedException {
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo/accesskeys.html");
		
		WebElement clickButton = driver
				.findElement(By.cssSelector("body > div.wy-grid-for-nav > section > div > div > div > p > span"));

		try {
			Actions action = new Actions(driver);
			Thread.sleep(3000);
			action.contextClick(clickButton).sendKeys(Keys.chord(Keys.ALT,"p")).perform();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		assertEquals("clicked: paste", alert.getText());
		
		alert.dismiss();
		
		Thread.sleep(5000);

	}

	// @Test
	// public void rightClickTest() {
	//// driver.navigate().to(URL);
	// By locator = By.cssSelector(".context-menu-one.box");
	// WebDriverWait wait = new WebDriverWait(driver, 5);
	// wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	// WebElement element=driver.findElement(locator);
	// rightClick(element);
	// WebElement elementEdit
	// =driver.findElement(By.cssSelector(".context-menu-item.icon.icon-edit>span"));
	// elementEdit.click();
	// Alert alert=driver.switchTo().alert();
	// String textEdit = alert.getText();
	// Assert.assertEquals(textEdit, "clicked: edit", "Failed to click on Edit
	// link");
	// }
	//
	// public void rightClick(WebElement element) {
	// try {
	// Actions action = new Actions(driver).contextClick(element);
	// action.build().perform();
	//
	// System.out.println("Sucessfully Right clicked on the element");
	// } catch (StaleElementReferenceException e) {
	// System.out.println("Element is not attached to the page document "
	// + e.getStackTrace());
	// } catch (NoSuchElementException e) {
	// System.out.println("Element " + element + " was not found in DOM "
	// + e.getStackTrace());
	// } catch (Exception e) {
	// System.out.println("Element " + element + " was not clickable "
	// + e.getStackTrace());
	// }
	// }

	@AfterClass
	public static void tearDown() throws Exception {
		driver.close();
		driver.quit();
		System.out.println("### TEAR DOWN ###");
	}

}