package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils {

    public static void takeScreenshot(String name) {
        TakesScreenshot ts =
            (TakesScreenshot) DriverFactory.getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src,
                new File("reports/screenshots/" + name + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
