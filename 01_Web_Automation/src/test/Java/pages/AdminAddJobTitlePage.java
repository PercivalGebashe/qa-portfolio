package pages;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.JobTitle;

public class AdminAddJobTitlePage extends BasePage implements LoadablePage{

    @FindBy(xpath = "//h6[normalize-space()='Add Job Title']")
    private WebElement pageHeading;

    @FindBy(xpath = "//form//input")
    private WebElement inputTextFieldJobCategoryName;

    @FindBy(xpath = "//form//button[text()=' Save ']")
    private WebElement buttonSaveJobTitle;

    @FindBy(xpath = "//div[contains(@class, 'oxd-toast--success')]")
    private WebElement successMessage;

    public AdminAddJobTitlePage(DriverManager driverManager) {
        super(driverManager);
    }

    public void saveJobTitle(JobTitle title){
        type(inputTextFieldJobCategoryName, title.getJobTitle());
        click(buttonSaveJobTitle);
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
