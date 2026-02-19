package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminJobTitlesPage extends BasePage implements LoadablePage{

    @FindBy(xpath = "//h6[normalize-space()='Job Titles']")
    private WebElement pageHeading;

    @FindBy(xpath = "//span[contains(normalize-space(),'Records Found')]")
    private WebElement recordsSpan;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement buttonAddTitle;

    public AdminJobTitlesPage(DriverManager driverManager){
        super(driverManager);
    }

    public WebElement getCategory(String titleName){
        By locator = By.xpath("//div[@class='oxd-table-card'][normalize-space() = '" + titleName + "']");
        return findBy(locator);
    }

    public void addJobTitle(){
        click(buttonAddTitle);
    }

    @Override
    public void waitUntilLoaded() {
        waitForVisibilityOf(pageHeading);
        waitForVisibilityOf(recordsSpan);
    }

    @Override
    public boolean isLoaded() {
        return isDisplayed(pageHeading) && isDisplayed(recordsSpan);
    }
}
