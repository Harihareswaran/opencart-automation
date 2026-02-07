package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class WaitUtils {
	public static WebElement waitForVisible(By locator) {
	    return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20))
	           .until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForClickable(By locator) {
	    return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20))
	           .until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void click(By locator) {
	    waitForClickable(locator).click();
	}

	public static void sendKeys(By locator, String text) {
	    WebElement element = waitForVisible(locator);
	    element.clear();
	    element.sendKeys(text);
	}

}
