package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class PimPage {

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement buttonAddUser;

    public PimPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }
}
