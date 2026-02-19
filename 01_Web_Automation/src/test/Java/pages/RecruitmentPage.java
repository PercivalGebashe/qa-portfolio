package pages;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitmentPage extends BasePage implements LoadablePage{

    @FindBy(xpath = "//h6[normalize-space()='Recruitment']")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[normalize-space()='Vacancies']")
    private WebElement vacancies;

    @FindBy(xpath = "//a[normalize-space()='Candidates']")
    private WebElement candidates;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement buttonAddCandidate;

    @FindBy(xpath = "//span[contains(normalize-space(),'Records Found')]")
    private WebElement recordsSpan;

    public RecruitmentPage(DriverManager driverManager){
        super(driverManager);
    }


    public void openVacancyPage() {
        click(vacancies);
    }

    public void openCandidatesPage(){
        click(candidates);
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
