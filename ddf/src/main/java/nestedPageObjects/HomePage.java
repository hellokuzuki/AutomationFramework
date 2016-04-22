package nestedPageObjects;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

/*Create the HomePage class, which allows the test to navigate to the home page of
*the application. It also provides access to the Search class, which is shared among
*the various pages of the application
*/
public class HomePage extends LoadableComponent<HomePage>{

	private WebDriver driver;
	
	static String url = "https://github.com/";
	
	private static String title = "GitHub"; 
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void isLoaded() throws Error {
		assertEquals(title,driver.getTitle());
	}

	@Override
	protected void load() {
		Browser.open(url);
	}
	
//	public Search search(){
//		Search search = new Search(driver);
//		return search;
//	}
	
}
