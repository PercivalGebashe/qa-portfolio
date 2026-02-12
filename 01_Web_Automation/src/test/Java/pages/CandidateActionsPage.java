package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class CandidateActionsPage {

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


    public CandidateActionsPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void shortlistCandidate(){
        DriverFactory.click(buttonShortlist);
    }

    public void scheduleInterview() {
        DriverFactory.click(buttonScheduleInterview);
    }

    public void markInterviewPassed() {
        DriverFactory.click(buttonMarkInterviewPassed);
    }

    public void offerJob() {
        DriverFactory.click(buttonOfferJob);
    }

    public void hireCandidate() {
        DriverFactory.click(buttonHire);
    }

    public String getCurrentStatus() {
        return DriverFactory.getText(currentStatus);
    }
}
