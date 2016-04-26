package nestedPageObjects;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
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
	
	public void login(){
		this.driver.findElement(By.linkText("Sign in")).click();
		this.driver.findElement(By.id("login_field")).click();
		this.driver.findElement(By.id("login_field")).sendKeys("mark.wang@appscore.com.au");
		this.driver.findElement(By.id("password")).sendKeys("kuzuki775885");
		this.driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/input[3]")).click();
	}

	@Override
	protected void isLoaded() throws Error {
		assertEquals("How people build software · GitHub",driver.getTitle());
	}

	@Override
	protected void load() {
		Browser.open(url);
	}
	
	public Search search(){
		Search search = new Search(driver);
		return search;
	}
	
}
