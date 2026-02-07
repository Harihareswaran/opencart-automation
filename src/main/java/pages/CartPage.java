package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;
import utils.WaitUtils;

public class CartPage {

    // Cart dropdown button
    By cartBtn = By.id("cart");

    // View Cart link (inside dropdown)
    By viewCart = By.xpath("//a[contains(@href,'checkout/cart')]");

    // Checkout link (inside dropdown)
    By checkoutBtn = By.xpath("//a[contains(@href,'checkout/checkout')]");

    // Remove product button
    By removeBtn = By.xpath("//button[@title='Remove']");

    // Empty cart message
    By emptyMsg = By.xpath("//p[contains(text(),'Your shopping cart is empty')]");

    // ---------------- ACTIONS ----------------

    public void openCart() {
        // Step 1: click cart button to open dropdown
        WaitUtils.click(cartBtn);

        // Step 2: click View Cart
        WaitUtils.click(viewCart);
    }

    public void proceedToCheckout() {
        // Step 1: click cart button
        WaitUtils.click(cartBtn);

        // Step 2: click Checkout
        WaitUtils.click(checkoutBtn);
    }

    public void removeItem() {
        WaitUtils.click(cartBtn);   // open dropdown
        WaitUtils.click(removeBtn); // remove item
    }

    public boolean isCartEmpty() {
        return WaitUtils.waitForVisible(emptyMsg).isDisplayed();
    }
}
