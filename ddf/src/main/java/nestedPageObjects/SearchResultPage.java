package nestedPageObjects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		assertEquals("Search · " + this.keyword, driver.getTitle());
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
	}
	
	public List<String> getProducts(){
		List<String> products = new ArrayList<String>();
		List<WebElement> productList = driver.findElements(By.cssSelector(".repo-list-item, .public, .source >li"));
		for (WebElement item : productList) {
			products.add(item.findElement(By.cssSelector("h3 > a")).getText());
			System.out.println(item.findElement(By.cssSelector("h3 > a")).getText());
		}
		return products;
	}
	
	public Search search(){
		Search search = new Search(driver);
		return search;
	}
	
	

}
