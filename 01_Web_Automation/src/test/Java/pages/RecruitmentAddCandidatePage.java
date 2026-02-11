package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    public void saveCandidate(String firstName, String lastName, String vacancyName, String email){
        DriverFactory.type(inputTextFieldFirstName, firstName);
        DriverFactory.type(inputTextFieldLastName, lastName);
//        DriverFactory.click(selectButton);
//        DriverFactory.click(getSelectOption(vacancyName));
        DriverFactory.type(inputTextFieldEmail, email);
        DriverFactory.submit(buttonSaveCandidate);

    }

    private WebElement getSelectOption(String optionName){
        return DriverFactory
            .findBy(By.xpath("//div[oxd-select-dropdown]//div[oxd-select-option][normalize-space()='" +
                optionName + "']"));
    }
}
