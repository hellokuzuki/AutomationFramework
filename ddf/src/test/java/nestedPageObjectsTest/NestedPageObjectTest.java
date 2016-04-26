package nestedPageObjectsTest;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import nestedPageObjects.Browser;
import nestedPageObjects.HomePage;
import nestedPageObjects.SearchResultPage;

public class NestedPageObjectTest {

	@Test
	public void test() {
		
		try {
		HomePage homePage = new HomePage(Browser.driver());
		homePage.get();
		
		homePage.login();
		
		SearchResultPage searchResult = homePage.search().searchInStore("selenium");
		
		assertEquals(10, searchResult.getProducts().size());
		} finally{
			Browser.close();
		}
	}

}
