package core;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.PropertiesReader.getProperty;

public class WaitFactory {

    public static WebDriverWait createWait(WebDriver driver) {
        Duration explicitTimeout = Duration.ofSeconds(Integer.parseInt(getProperty("explicitWait")));
        WebDriverWait wait = new WebDriverWait(driver, explicitTimeout);

        Duration pollingTime = Duration.ofMillis(Integer.parseInt(getProperty("pollingTime")));
        wait.pollingEvery(pollingTime);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);

        return wait;
    }
}
