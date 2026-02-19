package pages;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdminPage extends BasePage implements LoadablePage{

    @FindBy(xpath = "//h6[text()='Admin']")
    private WebElement pageTitle;

    @FindBy(xpath = "//span[contains(normalize-space(),'Records Found')]")
    private WebElement recordsSpan;

    @FindBy(xpath = "//nav[@aria-label = 'Topbar Menu']//li[normalize-space()='User Management']")
    private WebElement userManagementMenu;

    @FindBy(xpath = "//a[normalize-space()='Users']")
    private WebElement users;

    @FindBy(xpath = "//nav[@aria-label = 'Topbar Menu']//li[normalize-space()='Job']")
    private WebElement jobMenu;

    @FindBy(xpath = "//ul[@class='oxd-dropdown-menu']//li")
    private List<WebElement> JobMenuOptions;

    @FindBy(xpath = "//a[normalize-space()='Job Titles']")
    private WebElement jobTitles;

    @FindBy(xpath = "//a[normalize-space()='Job Categories']")
    private WebElement jobCategories;


    public AdminPage(DriverManager driverManager){
        super(driverManager);
    }

    public void openUserManagement(){
        click(userManagementMenu);
        click(users);
    }

    public void openJobMenu(){
        click(jobMenu);
    }

    public void openJobTitle(){
        click(jobTitles);
    }

    public void openJobCategories(){
        click(jobMenu);
        click(jobCategories);
    }

    public boolean jobMenuOptionsDisplayed(){
        return !findBy(JobMenuOptions).isEmpty();
    }

    @Override
    public void waitUntilLoaded() {
        waitForVisibilityOf(pageTitle);
        waitForVisibilityOf(recordsSpan);
    }

    @Override
    public boolean isLoaded() {
        return isDisplayed(pageTitle) && isDisplayed(recordsSpan);
    }
}
