package pages;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage implements LoadablePage{

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='orangehrm-attendance-card-summary-week']//p[normalize-space()='This Week']")
    private WebElement thisWeekPTag;

    public DashboardPage(DriverManager driverManager){
        super(driverManager);
    }

    @Override
    public void waitUntilLoaded() {
        waitForVisibilityOf(pageTitle);
        waitForVisibilityOf(thisWeekPTag);
    }

    @Override
    public boolean isLoaded() {
        return isDisplayed(pageTitle) && isDisplayed(thisWeekPTag);
    }
}
