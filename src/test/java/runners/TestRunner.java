package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "classpath:features",   // use classpath style
    glue = {"stepdefinitions", "hooks"},
    tags = "@Smoke or @Regression or @Integration or @E2E or @Negative",
    plugin = {
        "pretty",
        "html:reports/cucumber-report.html",
        "json:reports/cucumber-report.json"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // TestNG + Cucumber runner
}
