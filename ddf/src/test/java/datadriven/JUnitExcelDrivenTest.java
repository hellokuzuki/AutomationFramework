package datadriven;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import readExcelData.SpreadsheetData;
import utility.BrowserFactory;


@RunWith(Parameterized.class)
public class JUnitExcelDrivenTest {
	
	private static WebDriver driver;
	
	private String username;
	private String password;
	
	public JUnitExcelDrivenTest(String username, String password) {
//		super();
		this.username = username;
		this.password = password;
	}
	
	@Parameters
	public static Collection <Object[]> testData() throws Exception{
		InputStream spreadsheet = new FileInputStream("./Resource/Data/testdata.xls");
		return new SpreadsheetData(spreadsheet).getData();
	}
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get("http://www.davidjones.com.au");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}


	
	@Test
	public void test() {

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

		userName.sendKeys(username);
		assertEquals(username, userName.getAttribute("value"));

		passWord.sendKeys(password);

		// submit
		form.submit();

		assertEquals("My Account", driver.getTitle());

		// logout
		driver.findElement(By.cssSelector("#user-cart > p > a")).click();
		
	}
	


}
