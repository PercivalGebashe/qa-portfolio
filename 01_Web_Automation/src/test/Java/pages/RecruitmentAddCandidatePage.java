package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.Candidate;
import utils.DriverFactory;

public class RecruitmentAddCandidatePage {

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


    public RecruitmentAddCandidatePage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void saveCandidate(Candidate candidate){
        DriverFactory.type(inputTextFieldFirstName, candidate.getFirstName());
        DriverFactory.type(inputTextFieldLastName, candidate.getLastName());
        DriverFactory.click(selectButton);
        DriverFactory.click(getSelectOption(candidate.getVacancyName()));
        DriverFactory.type(inputTextFieldEmail, candidate.getEmail());
        DriverFactory.submit(buttonSaveCandidate);

    }

    private WebElement getSelectOption(String optionName){
        return DriverFactory
            .findBy(By.xpath("//div[oxd-select-dropdown]//div[oxd-select-option][normalize-space()='" +
                optionName + "']"));
    }
}
