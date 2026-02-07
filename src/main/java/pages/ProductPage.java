package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ElementClickInterceptedException;
import utils.DriverFactory;
import utils.WaitUtils;

public class ProductPage {

    By productLink = By.linkText("MacBook");
    By addToCartBtn = By.id("button-cart");
    By successMsg = By.cssSelector(".alert-success");

    public void selectProduct() {
        WebElement product = WaitUtils.waitForVisible(productLink);

        // Scroll into view
        ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", product);

        // Try click, fallback to JS click if intercepted
        try {
            WaitUtils.waitForClickable(productLink).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].click();", product);
        }
    }

    public void addToCart() {
        WebElement btn = WaitUtils.waitForVisible(addToCartBtn);
        try {
            btn.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].click();", btn);
        }
    }

    public boolean isProductAdded() {
        return WaitUtils.waitForVisible(successMsg).isDisplayed();
    }
}
