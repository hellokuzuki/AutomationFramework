package extensions;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.TakesScreenshot;

public class WebElementExtender {

	public static void setAttribute(WebElement element, String attributeName, String Value) {

		WrapsDriver wrappedElement = (WrapsDriver) element;
		JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
		driver.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, attributeName, Value);
	}

	public static void highlightElement(WebElement element) {
		for (int i = 0; i < 100; i++) {
			WrapsDriver wrappedElement = (WrapsDriver) element;
			JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
			driver.executeScript("arguments[0].setAttribute('style',arguments[1])", element,
					"color: green; border: 2px solid	yellow;");
			driver.executeScript("arguments[0].setAttribute('style',arguments[1])", element,"");
		}
	}
	
	public static File captureElementPicture(WebElement element) throws Exception{
		
		
		WrapsDriver wrapsDriver = (WrapsDriver) element;
		
		File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
		
		BufferedImage img = ImageIO.read(screen);
		
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		
		Rectangle rect = new Rectangle(width, height);
		
		Point p = element.getLocation();
		
		System.out.println("Point is " + p.toString());
		
		BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
		
		ImageIO.write(dest, "png", screen);
		
		return screen;
	}

}
