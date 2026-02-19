package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.Interview;

public class RecruitmentChangeCandidateStatusPage extends BasePage implements LoadablePage {

    @FindBy(xpath = "//form//div[contains(@class,'oxd-input-group')][normalize-space()='Candidate']//input")
    private WebElement inputCandiDateName;

    @FindBy(xpath = "//form//div[contains(@class, 'oxd-input-group')][normalize-space()='Interview Title']//input")
    private WebElement inputTextFieldInterviewTitle;

    @FindBy(xpath = "//form//div[contains(@class, 'oxd-input-group')][normalize-space()='Interviewer']//input")
    private WebElement inputTextFieldInterviewer;

    @FindBy(xpath = "//form//div[contains(@class, 'oxd-input-group')][normalize-space()='Date']//input")
    private WebElement inputFieldInterviewDate;

    @FindBy(xpath = "//form//button[normalize-space()='Save']")
    private WebElement buttonSaveAction;


    public RecruitmentChangeCandidateStatusPage(DriverManager driverManager){
        super(driverManager);;
    }

    private WebElement getInterviewer(String name){
        return findBy(By.xpath("//form//div[contains(@class, 'oxd-autocomplete-option')]" +
                "[normalize-space()='" + name + "']"));
    }

    public void saveInterview(Interview interview){
        type(inputTextFieldInterviewTitle, interview.getTitle());
        type(inputTextFieldInterviewer, interview.getInterviewer());
        click(getInterviewer(interview.getInterviewer()));
        type(inputFieldInterviewDate, interview.getDate());
        inputFieldInterviewDate.sendKeys(Keys.TAB);
        saveDetails();
    }

    @Override
    public void waitUntilLoaded() {
        waitForVisibilityOf(inputCandiDateName);
        waitForPageReady();
    }

    @Override
    public boolean isLoaded() {
        return isDisplayed(inputCandiDateName);
    }

    public void saveDetails(){
        click(buttonSaveAction);
    }
}
