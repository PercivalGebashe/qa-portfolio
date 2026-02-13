package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.Interview;
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

    @FindBy(xpath = "//form//button[normalize-space()='Save']")
    private WebElement buttonSaveAction;

    @FindBy(xpath = "//form//div[contains(@class, 'oxd-input-group')][normalize-space()='Interview Title']//input")
    private WebElement inputTextFieldInterviewTitle;

    @FindBy(xpath = "//form//div[contains(@class, 'oxd-input-group')][normalize-space()='Interviewer']//input")
    private WebElement inputTextFieldInterviewer;

    @FindBy(xpath = "//form//div[contains(@class, 'oxd-input-group')][normalize-space()='Date']//input")
    private WebElement inputFieldInterviewDate;



    public CandidateActionsPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void shortlistCandidate(){
        DriverFactory.click(buttonShortlist);
        saveAction();
    }

    public void scheduleInterview(Interview interview) {
        DriverFactory.click(buttonScheduleInterview);
        DriverFactory.type(inputTextFieldInterviewTitle, interview.getTitle());
        DriverFactory.type(inputTextFieldInterviewer, interview.getInterviewer());
        DriverFactory.click(getInterviewer(interview.getInterviewer()));
//        DriverFactory.click(inputFieldInterviewDate);
        DriverFactory.type(inputFieldInterviewDate, interview.getDate());
        inputFieldInterviewDate.sendKeys(Keys.TAB);
        saveAction();
    }

    public void markInterviewPassed() {
        DriverFactory.click(buttonMarkInterviewPassed);
        saveAction();
    }

    public void offerJob() {
        DriverFactory.click(buttonOfferJob);
        saveAction();
    }

    public void hireCandidate() {
        DriverFactory.click(buttonHire);
        saveAction();
    }

    public String getCurrentStatus() {
        return DriverFactory.getText(currentStatus);
    }

    private void saveAction(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        DriverFactory.submit(buttonSaveAction);
    }

    private WebElement getInterviewer(String name){
        return DriverFactory
                .findBy(By.xpath("//form//div[contains(@class, 'oxd-autocomplete-option')]" +
                        "[normalize-space()='" + name + "']"));
    }
}
