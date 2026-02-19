package pages;

import core.DriverManager;
import core.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(DriverManager driverManager){
        driver = driverManager.getDriver();
        wait = WaitFactory.createWait(driver);

        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver(){
        if (driver != null){
            return driver;
        }
        throw new RuntimeException("Driver null");
    }

    public WebDriverWait getWait(){
        if(wait != null){
            return wait;
        }
        throw new RuntimeException("WebDriverWait null");
    }


    public void click(WebElement element){
        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(element)))
            .click();

    }

    public void type(WebElement element, String value){
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(element)))
                .clear();
        element.sendKeys(value);
    }

    public String getText(WebElement element){
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(element)))
                .getText();
    }


    public void waitForVisibilityOf(WebElement element){
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(element)));
    }


    public WebElement findBy(By locator){
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    public List<WebElement> findBy(List<WebElement> webElement){
        return wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
    }

    public String getAttribute(WebElement webElement, String value) {
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(webElement)))
                .getAttribute(value);
    }

    protected void waitForInvisibilityOf(WebElement webElement) {
        Objects.requireNonNull(wait.until(ExpectedConditions.invisibilityOf(webElement)));
    }

    protected boolean isDisplayed(WebElement webElement) {
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(webElement)))
                .isDisplayed();
    }

    public boolean successDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".oxd-form-loader")
        ));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".oxd-form-loader")
        ));
        return true;
    }

    public void waitForPageReady() {
        By spinner = By.xpath("//div[@class='oxd-loading-spinner-container']");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
    }

}
