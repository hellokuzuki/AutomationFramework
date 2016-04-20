package datadriven;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencsv.CSVReader;

import utility.BrowserFactory;

@RunWith(Parameterized.class)
public class JUnitCSVDataDrivenTest {
	
	private static WebDriver driver;
	
	private String username;
	private String password;
	
	public JUnitCSVDataDrivenTest(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Parameters
	public static List<String[]> testData() throws IOException{
		List<String[]> data = getCSVData("./Resource/Data/testdata.csv");
		
		//Print all elements of List.
		System.out.println(Arrays.deepToString(data.toArray()));
		return data;
	}
	
	public static List<String[]> getCSVData(String filename) throws IOException {
		//Check the usage of oopenCSV on http://opencsv.sourceforge.net/
		CSVReader reader = new CSVReader(new FileReader(filename));
		List<String[]> myEntries = reader.readAll();
		reader.close();
		System.out.println("getLinesRead = " + reader.getLinesRead());
		System.out.println("getRecordsRead = " + reader.getRecordsRead());
		return myEntries;
	}


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get("http://www.davidjones.com.au");
		System.out.println("### SET UP BEFORE CLASS ###");
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
