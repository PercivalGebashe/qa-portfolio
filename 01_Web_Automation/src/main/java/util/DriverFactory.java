package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverFactory {

    private static final String BASE_PATH = System.getProperty("user.dir");
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Properties properties;

    public static void setDriver(){
        loadProperties();
        String browser = getProperty("browser");
        String headless = getProperty("headless");
        System.out.println("Browser: " + browser);

        switch (browser.toLowerCase()){
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments(headless);
                driver = new EdgeDriver(edgeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(headless);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(headless);
                driver = new ChromeDriver(chromeOptions);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Integer.parseInt(getProperty("implicitWait")))
        );
        wait = new WebDriverWait(driver,
                Duration.ofSeconds(Integer.parseInt(getProperty("explicitWait"))
                ));
    }

    public static void tearDownDriver(){
        if(driver != null){
//            driver.close();
            driver.quit();
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
}
