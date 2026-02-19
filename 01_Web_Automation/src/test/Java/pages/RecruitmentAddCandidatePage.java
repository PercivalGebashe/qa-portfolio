package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.Candidate;

public class RecruitmentAddCandidatePage extends BasePage implements LoadablePage{

    @FindBy(xpath = "//h6[normalize-space()='Add Candidate']")
    private WebElement pageHeading;

    @FindBy(xpath = "//form//input[@name = 'firstName']")
    private WebElement inputTextFieldFirstName;

    @FindBy(xpath = "//form//input[@name = 'lastName']")
    private WebElement inputTextFieldLastName;

    @FindBy(xpath = "//div[normalize-space()='Vacancy']/following-sibling::div")
    private WebElement selectButton;

    @FindBy(xpath = "//div[normalize-space()='Email']/descendant::input")
    private WebElement inputTextFieldEmail;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement buttonSaveCandidate;


    public RecruitmentAddCandidatePage(DriverManager driverManager){
        super(driverManager);
    }

    public void saveCandidate(Candidate candidate){
        type(inputTextFieldFirstName, candidate.getFirstName());
        type(inputTextFieldLastName, candidate.getLastName());
        click(selectButton);
        click(getSelectOption(candidate.getVacancyName()));
        type(inputTextFieldEmail, candidate.getEmail());
        click(buttonSaveCandidate);
    }

    private WebElement getSelectOption(String optionName){
        return findBy(By.xpath("//form//div[@class='oxd-select-option'][normalize-space()='" + optionName + "']"));
    }

    @Override
    public void waitUntilLoaded() {
        waitForVisibilityOf(pageHeading);
    }

    @Override
    public boolean isLoaded() {
        return isDisplayed(pageHeading);
    }
}
