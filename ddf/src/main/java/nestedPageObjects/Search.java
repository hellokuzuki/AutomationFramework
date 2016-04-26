package nestedPageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {

	private WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/form/label/input")
	private WebElement search;
	
	public Search(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SearchResultPage searchInStore(String keyword) {
		search.click();
		search.sendKeys(keyword);
		search.sendKeys(Keys.ENTER);
		return new SearchResultPage(driver, keyword);
	}
	
	
}
