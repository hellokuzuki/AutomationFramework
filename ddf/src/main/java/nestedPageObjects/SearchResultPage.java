package nestedPageObjects;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class SearchResultPage extends LoadableComponent<SearchResultPage> {
	
	private WebDriver driver;
	
	private String keyword;
	
	public SearchResultPage(WebDriver driver, String keyword) {
		this.driver = driver;
		this.keyword = keyword;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertEquals("Search results for: '" + this.keyword + "'", driver.getTitle());
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
	}
	
	

}
