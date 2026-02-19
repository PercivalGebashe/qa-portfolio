package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.Interview;

public class RecruitmentCandidateActionsPage extends BasePage implements LoadablePage{

    @FindBy(xpath = "//h6[normalize-space()='Application Stage']")
    private WebElement pageHeading;

    @FindBy(xpath = "//span[contains(normalize-space(),'Records Found')]")
    private WebElement recordsSpan;

    @FindBy(xpath = "//div[@class='orangehrm-recruitment-status']//p")
    private WebElement currentStatus;

    @FindBy(xpath = "//button[normalize-space()='Shortlist']")
    private WebElement buttonShortlist;

    @FindBy(xpath = "//button[normalize-space()='Schedule Interview']")
    private WebElement buttonScheduleInterview;

    @FindBy(xpath = "//button[normalize-space()='Mark Interview Passed']")
    private WebElement buttonMarkInterviewPassed;

    @FindBy(xpath = "//button[normalize-space()='Offer Job']")
    private WebElement buttonOfferJob;

    @FindBy(xpath = "//button[normalize-space()='Hire']")
    private WebElement buttonHire;



    public RecruitmentCandidateActionsPage(DriverManager driverManager){
        super(driverManager);
    }

    public void shortlistCandidate(){
        click(buttonShortlist);
    }

    public void scheduleInterview() {
        click(buttonScheduleInterview);
    }

    public void markInterviewPassed() {
        click(buttonMarkInterviewPassed);
    }

    public void offerJob() {
        click(buttonOfferJob);
    }

    public void hireCandidate() {
        click(buttonHire);
    }

    public String getCurrentStatus() {
        return getText(currentStatus);
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
