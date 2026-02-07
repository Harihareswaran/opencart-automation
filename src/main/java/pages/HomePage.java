package pages;

import org.openqa.selenium.By;
import utils.WaitUtils;

public class HomePage {

    By searchBox = By.name("search");
    By searchBtn = By.xpath("//button[contains(@type,'submit')]/parent::form");

    public void searchProduct(String productName) {
        WaitUtils.sendKeys(searchBox, productName);
        WaitUtils.click(searchBtn);
    }

    public boolean isHomePageDisplayed() {
        return WaitUtils
                .waitForVisible(By.id("logo"))
                .isDisplayed();
    }
}
