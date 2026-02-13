package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

public class DriverFactory {

    private static final String BASE_PATH = System.getProperty("user.dir");
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Properties properties;

    public static void setDriver(){
        loadProperties();
        String browser = getProperty("browser");
        boolean isHeadless = Boolean.parseBoolean(getProperty("headless"));

        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if(isHeadless) chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if(isHeadless) edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if(isHeadless) firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new IllegalArgumentException(
                    "Invalid browser in config: " + browser + ". Expected: chrome, firefox, edge"
                );
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(getProperty("explicitWait")))
        );
    }

    public static void tearDownDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

    private static void loadProperties(){
        properties = new Properties();
        System.out.println("Base Path: " + BASE_PATH);
        File file = new File(BASE_PATH + "/configuration/config.properties");

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static String getProperty(String propertyName){
        return properties.getProperty(propertyName);
    }

    public static WebDriver getDriver(){
        if (driver != null){
            return driver;
        }
        throw new RuntimeException("Driver null");
    }

    public static WebDriverWait getWait(){
        if(wait != null){
            return wait;
        }
        throw new RuntimeException("WebDriverWait null");
    }

    public static void click(WebElement element){
        wait.until(d ->
                Objects.equals(((JavascriptExecutor) d)
                        .executeScript("return document.readyState"), "complete")
        );

        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            element.click();
        }
        catch (ElementClickInterceptedException e) {

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", element);
        }
    }

    public static void type(WebElement element, String value){
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(element)))
                .clear();
        element.sendKeys(value);
    }

    public static String getText(WebElement element){
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(element)))
                .getText();
    }


    public static void submit(WebElement element) {
        wait.until(d ->
                Objects.equals(((JavascriptExecutor) d)
                        .executeScript("return document.readyState"), "complete")
        );

        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            element.submit();
        }
        catch (ElementClickInterceptedException e) {

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", element);
        }
    }


    public static WebElement findBy(By locator){
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    public static void openWebsite(){
        driver.get(properties.getProperty("website"));
    }

    public static String getAttribute(WebElement webElement, String value) {
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(webElement)))
                .getAttribute(value);
    }

    public static String getCurrentTimeStamp(){
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Date now = new Date();
        return sdfDate.format(now);
    }
}
