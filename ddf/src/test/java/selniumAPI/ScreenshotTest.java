package selniumAPI;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import testBase.TestBase;
import utility.BrowserFactory;

public class ScreenshotTest extends TestBase{

	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		driver = BrowserFactory.getBrowser("Chrome");
		System.out.println("### SET UP BEFORE CLASS ###");
	}

	@Before
	public void setUp() throws Exception {

		driver.get("http://www.davidjones.com.au");
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
	public void testScreenshot(){
		
		String packageName = this.getClass().getPackage().getName();
		if(!new File("./Resource/Screenshot/" + packageName).exists()) {
			new File("./Resource/Screenshot/" + packageName).mkdirs();
		}
		
		System.out.println(name.getMethodName());
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./Resource/Screenshot/" + name.getMethodName() + "_" + new Date().toString() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
