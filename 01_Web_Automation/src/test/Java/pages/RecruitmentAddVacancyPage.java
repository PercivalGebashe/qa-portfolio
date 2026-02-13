package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.Vacancy;
import utils.DriverFactory;

public class RecruitmentAddVacancyPage {

    @FindBy(xpath = "//form//div[normalize-space()='Vacancy Name']//input")
    private WebElement inputTextFieldVacancyName;

    @FindBy(xpath = "//form//div[normalize-space()='Job Title']/following-sibling::div")
    private WebElement selectJobTitleButton;

    @FindBy(xpath = "//form//div[normalize-space()='Hiring Manager']//input")
    private WebElement inputTextFieldHiringManager;

    @FindBy(xpath = "//form//div[normalize-space()='Number of Positions']//input")
    private WebElement inputTextFieldNumberOfOpenPositions;

    @FindBy(xpath = "//form//button[normalize-space()='Save']")
    private WebElement buttonSaveVacancy;

    public RecruitmentAddVacancyPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void createVacancy(Vacancy vacancy){
        DriverFactory.type(inputTextFieldVacancyName, vacancy.getVacancyName());
        DriverFactory.click(selectJobTitleButton);
        DriverFactory.click(getSelectOption(vacancy.getJobTitle()));
        DriverFactory.type(inputTextFieldHiringManager, vacancy.getHiringManager());
        DriverFactory.click(getHiringManager(vacancy.getHiringManager()));
        DriverFactory.type(inputTextFieldNumberOfOpenPositions, vacancy.getNumberOfPositions());
        DriverFactory.submit(buttonSaveVacancy);
    }


    private WebElement getHiringManager(String name){
        return DriverFactory
            .findBy(By.xpath("//form//div[contains(@class, 'oxd-autocomplete-option')]" +
                "[normalize-space()='" + name + "']"));
    }

    private WebElement getSelectOption(String optionName){
        return DriverFactory
                .findBy(By.xpath("//div[@class='oxd-select-option'][normalize-space()='" +
                        optionName + "']"));
    }


}
