package utility;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	/*
	 * Factory method for getting browsers
	 */
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;

		String OS = "";

		if (System.getProperty("os.name").startsWith("Windows")) {
			OS = "Windows";
		} else if (System.getProperty("os.name").startsWith("Mac")) {
			OS = "Mac";
		} else {
			OS = "Others";
		}

		switch (browserName) {
		case "IE":
			driver = drivers.get("IE");
			if (driver == null) {

				if ("Windows" == OS) {
					System.setProperty("webdriver.ie.driver",
							System.getProperty("user.dir") + "\\WebDrivers\\iedriver\\IEDriverServer.exe");
				} else {
					System.out.println("*******Impossible to running IE on Other machines*******");
				}

				driver = new InternetExplorerDriver();
				drivers.put("IE", driver);
			}
			break;
		case "Chrome":
			driver = drivers.get("Chrome");
			if (driver == null) {

				if ("Windows" == OS) {
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "\\WebDrivers\\chromedriver\\chromedriver.exe");
				} else if ("Mac" == OS) {
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "/WebDrivers/chromedriver/chromedriver");
				} else {
					System.out.println("*******Please check your OS version!*******");
				}

				driver = new ChromeDriver();
				drivers.put("Chrome", driver);
			}
			break;
		case "Firefox":
			driver = drivers.get("Firefox");
			if (driver == null) {
				driver = new FirefoxDriver();
				drivers.put("Firefox", driver);
			}
			break;
		default:
			System.out.print("*******Please check your browser setting!*******");
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	// public static void quit() {
	// if (driver != null) {
	// driver.quit();
	// }
	// }

	public static void closeAllDriver() {
		for (String key : drivers.keySet()) {
			drivers.get(key).close();
			drivers.get(key).quit();
		}
	}
}
