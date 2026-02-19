package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitmentVacancyPage extends BasePage implements LoadablePage{

    @FindBy(xpath = "//h5[normalize-space()='Vacancies']")
    private WebElement pageTitle;

    @FindBy(xpath = "//span[contains(normalize-space(),'Records Found')]")
    private WebElement recordsSpan;

    @FindBy(xpath = "//button[normalize-space()= 'Add']")
    private WebElement buttonAddVacancy;

    public RecruitmentVacancyPage(DriverManager driverManager){
        super(driverManager);
    }

    public WebElement getVacancy(String vacancy){
        By locator = By
                .xpath("//div[@class='oxd-table-card']//div[normalize-space(.)='" + vacancy + "']");
        return findBy(locator);
    }

    public void addVacancy(){
        click(buttonAddVacancy);
    }

    @Override
    public void waitUntilLoaded() {
        waitForVisibilityOf(pageTitle);
        waitForVisibilityOf(recordsSpan);
    }

    @Override
    public boolean isLoaded() {
        return isDisplayed(pageTitle) && isDisplayed(recordsSpan);
    }
}
