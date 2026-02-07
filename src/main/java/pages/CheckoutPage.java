package pages;

import org.openqa.selenium.By;
import utils.DriverFactory;
import utils.WaitUtils;

public class CheckoutPage {

    By checkoutHeading = By.xpath("//h1[contains(text(),'Checkout')]");
    By continueBtn = By.id("button-payment-address");
    By iframe = By.cssSelector("iframe");

    // Verify we're on the checkout page
    public boolean isCheckoutPageDisplayed() {
        return WaitUtils.waitForVisible(checkoutHeading).isDisplayed();
    }

    // Example iframe handling (payment)
    public void handlePaymentFrame() {
        WaitUtils.waitForVisible(iframe);
        DriverFactory.getDriver().switchTo().frame(0);
        DriverFactory.getDriver().switchTo().defaultContent();
    }
}