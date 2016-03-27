package locators;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.BrowserFactory;

public class ElementMethodTest {
	
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.out.println("### SET UP ###");
		driver = BrowserFactory.getBrowser("Chrome");
//		driver.get("http://www.davidjones.com.au");

	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.close();
		driver.quit();
		System.out.println("### TEAR DOWN ###");
	}

	@Ignore
	@Test
	public void textClearTest() {
		WebElement loginButton = driver.findElement(By.id("headerLogin"));
		loginButton.click();
		
		WebElement userName = driver.findElement(By.name("logonId"));
		WebElement passWord = driver.findElement(By.name("logonPassword"));
		WebElement form = driver.findElement(By.id("Logon"));
		
		userName.sendKeys("abcdef");
		assertEquals("abcdef", userName.getAttribute("value"));
		
		passWord.sendKeys("111111");

		userName.clear();
		assertEquals("", userName.getAttribute("value"));
		
		passWord.clear();
		
		userName.sendKeys("testuser@yopmail.com");
		assertEquals("testuser@yopmail.com", userName.getAttribute("value"));
		
		passWord.sendKeys("111111");
		
		form.submit();
		
		assertEquals("My Account", driver.getTitle());
	}
	
	@Ignore
	@Test
	public void getTextTest(){
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/a"));
		assertEquals("David Jones", logo.getText());
		
		//Get hiden text from element
		WebElement hidenText = driver.findElement(By.xpath("//*[@id=\"MiniCartFocusReceiver2\"]/p"));
		System.out.println(hidenText.getAttribute("innerText"));
//		System.out.println(hidenText.getText());
	}
	@Ignore
	@Test
	public void getCssValueTest(){
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]"));
		assertEquals("940px", logo.getCssValue("width"));
	}
	
	@Ignore
	@Test
	public void dropDownListTest(){
		
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
		
		Select title = new Select (driver.findElement(By.name("personTitle")));
		
		assertFalse(title.isMultiple());
		
		assertEquals(6, title.getOptions().size());
		
		title.selectByVisibleText("DR");
		assertEquals("DR", title.getFirstSelectedOption().getText());
		
		title.selectByIndex(4);
		assertEquals("MISS", title.getFirstSelectedOption().getText());
		
		title.selectByValue("MRS");
		assertEquals("MRS", title.getFirstSelectedOption().getText());
		
		List<WebElement> ulist = driver.findElements(By.xpath("//*[@id=\"Register\"]/fieldset[3]/ul/li[2]/ul/li"));
		
		for (WebElement list : ulist){
			System.out.println(list.getText());
		}
		
	}
	
	@Ignore
	@Test
	public void checkingSelectedOptionTest(){
		
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
		
		Select title = new Select (driver.findElement(By.name("personTitle")));
		assertEquals(6, title.getOptions().size());
		
		List<String> expectList = Arrays.asList("SELECT", "MR", "MS", "MRS", "MISS", "DR");
		
		List<String> actualList = new ArrayList<String>();
		
		for(WebElement options : title.getOptions()) {
			actualList.add(options.getText());
		}
		
		assertArrayEquals(expectList.toArray(), actualList.toArray());
		
	}
	
	@Ignore
	@Test
	public void radioButtonAndGroupTest(){
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		
		WebElement petrol = driver.findElement(By.xpath("//*[@id=\"tabs-1\"]/p[2]/input[1]"));
		
		if(!petrol.isSelected()) {
			petrol.click();
		}
		
		assertTrue(petrol.isSelected());
		
		List<WebElement> radios = driver.findElements(By.name("fuel_type"));
		
		for(WebElement ra : radios) {
			if(ra.getAttribute("value").equals("Diesel")) {
				if(!ra.isSelected()) {
					ra.click();
				}
				assertTrue(ra.isSelected());
				break;
			}
		}
	}
	
	@Ignore
	@Test
	public void checkBoxsTest(){
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
		
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"Register\"]/fieldset[3]/ul/li[2]/ul/li[5]"));
		
		
		if(!checkbox.isSelected()){
			checkbox.click();
		}
		System.out.println(checkbox.isSelected());
//		assertTrue(checkbox.isSelected());
		
		if(checkbox.isSelected()) {
			checkbox.click();
		}
//		assertFalse(checkbox.isSelected());
		
	}
	
	@Test
	public void webTableTest(){
		driver.get("http://cookbook.seleniumacademy.com/Locators.html");
		
		WebElement simpleTable = driver.findElement(By.id("items"));
		
		List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
		
		assertEquals(3, rows.size());
		
		for(WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for(WebElement col : cols ){
				System.out.println(col.getText() + "\t");
			}
			System.out.println();
			
		}
		
	}

}
