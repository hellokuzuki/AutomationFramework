package pageObjectsTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pageObjects.DavidJones_HomePage;

public class DavidJonesHomePageTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		driver = BrowserFactory.getBrowser("Chrome");
		System.out.println("### SET UP BEFORE CLASS ###");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("### SET UP EACH TEST ###");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("### TEAR DOWN EACH TEST ###");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("### TEAR DOWN AFTER CLASS###");
	}

	@Test
	public void test() {
		DavidJones_HomePage hp = new DavidJones_HomePage();
		
		hp.load();
		
		hp.text_Logo_click();
		assertEquals(hp.get_PageTitle(),"Shop Online at David Jones - Women's Fashion - Beauty -Shoes & Accessories - Men's Fashion - Children's Fashion - Home");
	
		hp.link_Contact_Us_click();
		
		assertEquals(hp.get_PageTitle(),"Contact Us - David Jones");
		hp.back();
		
		hp.close();
		
	}

}
