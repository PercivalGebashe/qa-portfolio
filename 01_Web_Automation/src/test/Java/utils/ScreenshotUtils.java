package utils;

import org.openqa.selenium.*;

import java.util.Base64;

public class ScreenshotUtils {

    public static String captureBase64(WebDriver driver) {
        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BASE64);
    }
}
