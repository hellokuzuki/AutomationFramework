package pageObjectsTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pageObjects.DavidJones_LoginPage;

public class DavidJonesLoginTest {

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

	//Test basic page objective model
	@Test
	public void test() {
		DavidJones_LoginPage login = new DavidJones_LoginPage();
		
		login.get();
		
		login.InputLoginId("testuser@yopmail.com");
		
		login.InputLogonPassword("111111");
		
		login.clickbtnSignIn();
		
		assertEquals("My Account",login.getPageTitle());
		
		login.close();
	}

}
