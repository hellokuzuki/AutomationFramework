package extensionsTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import extensions.WebTableHandler;
import utility.BrowserFactory;

public class WebHandlerTest {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get("http://www.tutorialspoint.com/html/html_tables.htm");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testWebTableTest() {
		WebTableHandler table = new WebTableHandler(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/div[1]/div/div[5]/table")));
		
		
		System.out.println(table.getRowCount());
		System.out.println(table.getColCount());
		System.out.println(table.getCellValue(1, 1));
		assertEquals(2, table.getRowCount());
		assertEquals(2, table.getColCount());
		assertEquals("Row 1, Column 1",table.getCellValue(1, 1));
	}

}
