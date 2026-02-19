package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitmentCandidatesPage extends BasePage implements LoadablePage{

    @FindBy(xpath = "//h5[normalize-space()='Candidates']")
    private WebElement pageHeading;

    @FindBy(xpath = "//span[contains(normalize-space(),'Records Found')]")
    private WebElement recordsSpan;

    @FindBy(xpath = "//button[normalize-space()= 'Add']")
    private WebElement buttonAddCandidate;

    public RecruitmentCandidatesPage(DriverManager driverManager){
        super(driverManager);
    }

    public WebElement getCandidate(String candidate){
        By locator = By
                .xpath("//div[@class='oxd-table-card']//div[normalize-space(.)='" + candidate + "']");
        return findBy(locator);
    }

    public void addCandidate(){
        click(buttonAddCandidate);
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
