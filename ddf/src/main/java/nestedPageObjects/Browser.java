package nestedPageObjects;

import org.openqa.selenium.WebDriver;

import utility.BrowserFactory;

//Create the Browser class, which will provide a static and shared WebDriver instance for all the pages

public class Browser {
	
	private static WebDriver driver = BrowserFactory.getBrowser("Chrome");
	
	public static WebDriver driver(){
		return driver;
	}

	public static void open(String url){
		driver.get(url);
	}
	
	public static void close(){
		driver.quit();
	}
	
}
