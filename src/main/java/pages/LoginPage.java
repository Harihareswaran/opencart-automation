package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.DriverFactory;
import utils.WaitUtils;

public class LoginPage {

    By email = By.id("input-email");
    By password = By.id("input-password");
    By loginBtn = By.xpath("//button[@class='btn btn-primary']");
    By warningMsg = By.cssSelector(".alert.alert-danger.alert-dismissible");

    // Menu + Login link (hover needed)
    By myAccountMenu = By.linkText("My Account"); // adjust if menu text is different
    By loginPageLink = By.linkText("Login");       // Login inside the dropdown

    // Navigate to Login page with hover
    public void openLoginPage() {
        WebElement menu = WaitUtils.waitForVisible(myAccountMenu);
        Actions actions = new Actions(DriverFactory.getDriver());
        actions.click(menu).perform(); // hover

        // wait for Login link and click
        WebElement loginLink = WaitUtils.waitForClickable(loginPageLink);
        loginLink.click();
    }

    // Perform login
    public void login(String user, String pass) {
        WaitUtils.sendKeys(email, user);
        WaitUtils.sendKeys(password, pass);
        
        // wait for button to be clickable before clicking
        WebElement btn = WaitUtils.waitForClickable(loginBtn);
        btn.click();
    }


    // Check if warning message is displayed
    public boolean isWarningDisplayed() {
        return WaitUtils.waitForVisible(warningMsg).isDisplayed();
    }
}
