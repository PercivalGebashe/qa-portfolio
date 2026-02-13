package utils;

import org.openqa.selenium.*;

public class ScreenshotUtils {

    public static String captureBase64() {
        return ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.BASE64);
    }
}
