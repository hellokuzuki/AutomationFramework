package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.BrowserFactory;

public class DavidJones_HomePage {
	
	private WebDriver driver;
	private String url = "http://www.davidjones.com.au";
	
	//Constructor
	public DavidJones_HomePage (){
		this.driver = BrowserFactory.getBrowser("Chrome");
		PageFactory.initElements(driver, this);
	}
	
	//List Up all the element to be tested.
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[1]/a")
	private WebElement text_Logo;
	
	@FindBy(xpath = "//*[@id=\"header_links\"]/ul/li[1]/a")
	private WebElement link_Gift_Registry;
	
	@FindBy(id = "WC_CachedHeaderDisplay_Link_6")
	private WebElement link_Wish_List;
	
	@FindBy(linkText = "Contact us")
	@CacheLookup
	private static WebElement link_Contact_Us;
	
	@FindBy(id = "SimpleSearchForm_SearchTerm")
	private WebElement input_Search_Box;
	
	@FindBy(xpath = "//*[@id=\"header-search\"]/input[3]")
	private WebElement btn_Search;
	
	@FindBy(linkText = "Sign In")
	private WebElement link_SignIn;
	
	@FindBy(linkText = "Create an Account")
	private WebElement link_Create_Account;
	
	@FindBy(id = "shoppingCartBar")
	private WebElement shoppingCartBar;
	
	@FindBy(xpath = "//*[@id=\"MiniCartFocusReceiver2\"]/p")
	private WebElement text_Shopping_Cart;
	
	//Click on Element methods
	public void text_Logo_click() {
		text_Logo.click();
	}

	public void link_Gift_Registry_click() {
		link_Gift_Registry.click();
	}
	
	public void link_Wish_List_click() {
		link_Wish_List.click();
	}
	
	public void link_Contact_Us_click() {
		link_Contact_Us.click();
	}
	
	public void input_Search_Keywords(String keyword) {
		input_Search_Box.clear();
		input_Search_Box.click();
		input_Search_Box.sendKeys(keyword);
		btn_Search.click();
	}

	public void link_SignIn_click() {
		link_SignIn.click();
	}
	
	public void link_Create_Account_click() {
		link_Create_Account.click();
	}
	
	public String get_PageTitle (){
		return this.driver.getTitle();
	}
	
	public void back(){
		this.driver.navigate().back();
	}
	
	public void load() {
		this.driver.get(url);
	}
	
	public void close(){
		this.driver.quit();
	}

}
