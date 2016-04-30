package extensionsTest;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import extensions.WebElementExtender;
import utility.BrowserFactory;
import utils.CompareImageUtil;

public class CompareImageTest {

	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get("https://www.davidjones.com.au/contact-us");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	@Test
	public void test() throws Exception {
		
		String srcFile = "./contactImage.jpg";
		String dstFile = "./dest_contact.jpg";
		String deskFakeFile = "./dest_contactfake.jpg";
		
		WebElement contactImage = driver.findElement(By.xpath("//*[@id=\"phmain_0_phcontent_1_imgBanner\"]"));
		
		FileUtils.copyFile(WebElementExtender.captureElementPicture(contactImage), new File(srcFile));
		
		assertEquals(CompareImageUtil.Result.Matched,CompareImageUtil.CompareImage(srcFile, srcFile));
		assertNotEquals(CompareImageUtil.Result.Matched,CompareImageUtil.CompareImage(srcFile, dstFile));
		assertNotEquals(CompareImageUtil.Result.Matched,CompareImageUtil.CompareImage(srcFile, deskFakeFile));
		
		FileUtils.forceDelete(new File(srcFile));
		
	}
	

}
