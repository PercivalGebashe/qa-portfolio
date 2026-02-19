package pages;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.Vacancy;

public class RecruitmentAddVacancyPage extends BasePage implements LoadablePage{

    @FindBy(xpath = "//h6[normalize-space()='Add Vacancy']")
    private WebElement pageHeading;

    @FindBy(xpath = "//h6[normalize-space()='Edit Vacancy']")
    private WebElement pageHeadingEdit;

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

    @FindBy(xpath = "//div[contains(@class, 'oxd-toast--success')]")
    private WebElement successMessage;

    @FindBy(xpath = "//span[contains(normalize-space(),'Records Found')]")
    private WebElement recordsSpan;

    public RecruitmentAddVacancyPage(DriverManager driverManager){
        super(driverManager);
    }

    public void createVacancy(Vacancy vacancy){
        type(inputTextFieldVacancyName, vacancy.getVacancyName());
        click(selectJobTitleButton);
        click(getSelectOption(vacancy.getJobTitle()));
        type(inputTextFieldHiringManager, vacancy.getHiringManager());
        click(getHiringManager(vacancy.getHiringManager()));
        type(inputTextFieldNumberOfOpenPositions, vacancy.getNumberOfPositions());
        click(buttonSaveVacancy);
    }


    private WebElement getHiringManager(String name){
        return findBy(By.xpath("//form//div[contains(@class, 'oxd-autocomplete-option')]" +
                "[normalize-space()='" + name + "']"));
    }

    private WebElement getSelectOption(String optionName){
        return findBy(By.xpath("//div[@class='oxd-select-option'][normalize-space()='" +
                        optionName + "']"));
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
