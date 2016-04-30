package extensions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PerformanceTiming {
	
	private long loadEventEnd;
	
	private long navigationStart;
	
	@SuppressWarnings("unused")
	private WebDriver driver;
	
	private JavascriptExecutor js;
	
	public PerformanceTiming(WebDriver driver){
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	}
	
	public long getLoadEventEnd() {
		
		loadEventEnd = (long) js.executeScript("return window.performance.timing.loadEventEnd;");
		
		return loadEventEnd;
	}
	
	public long getNavigationStart(){
		navigationStart = (long) js.executeScript("return window.performance.timing.navigationStart;");
		
		return navigationStart;
	}
	
	public long getPageLoadingTime(){
		getLoadEventEnd();
		getNavigationStart();
		return (this.getLoadEventEnd() - getNavigationStart())/1000;
	}
	
	

}
