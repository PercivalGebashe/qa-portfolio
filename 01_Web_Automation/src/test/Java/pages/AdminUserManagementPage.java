package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class AdminUserManagementPage {

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement buttonAddUser;

    public AdminUserManagementPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public WebElement getUser(String userName){
        By locator = By.xpath("//div[@class='oxd-table-card']//div[@role='cell'][normalize-space()= '" +
                userName + "']");
        return DriverFactory.findBy(locator);
    }

    public void addUser(){
        DriverFactory.click(buttonAddUser);
    }
}
