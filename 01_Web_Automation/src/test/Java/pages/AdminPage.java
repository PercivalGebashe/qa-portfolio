package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class AdminPage {

    @FindBy(xpath = "//nav[@aria-label = 'Topbar Menu']//li[normalize-space()='Job']")
    private WebElement jobMenu;

    @FindBy(xpath = "//a[normalize-space()='Job Titles']")
    private WebElement jobTitles;

    @FindBy(xpath = "//a[normalize-space()='Job Categories']")
    private WebElement jobCategories;


    public AdminPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void openJobTitle(){
        DriverFactory.click(jobMenu);
        DriverFactory.click(jobTitles);
    }

    public void openJobCategories(){
        DriverFactory.click(jobMenu);
        DriverFactory.click(jobCategories);
    }

}
