package nestedPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {

	private WebDriver driver;
	
	@FindBy(id = "SimpleSearchForm_SearchTerm")
	private WebElement search;
	
	@FindBy(xpath = "//*[@id=\"header-search\"]/input[3]")
	private WebElement searchButton;
	
	public Search(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	public SearchResults searchInStore(String keyword) {
//		search.click();
//		search.sendKeys(keyword);
//		searchButton.click();
//		return new SearchResults(driver, keyword);
//	}
	
	
}
