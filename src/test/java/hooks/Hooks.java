package hooks;

import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverFactory;
import utils.ScreenshotUtils;

public class Hooks {

    @Before
    public void setup() {
        // Initialize browser
        DriverFactory.initDriver();
        // Open application URL
        DriverFactory.getDriver().get(ConfigReader.get("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        // Take screenshot if scenario failed
        if (scenario.isFailed()) {
            ScreenshotUtils.takeScreenshot(scenario.getName());
        }
        // Close browser
        DriverFactory.quitDriver();
    }
}
