package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.AdminUser;
import utils.DriverFactory;

public class AdminAddUser {

    @FindBy(xpath = "//form//div[normalize-space()='User Role']/following-sibling::div")
    private WebElement buttonSelectUserRole;

    @FindBy(xpath = "//form//div[contains(@class,'oxd-input-group')][normalize-space()='Employee Name']//input")
    private WebElement inputTextFieldEmployeeName;

    @FindBy(xpath = "//form//div[contains(@class,'oxd-input-group')][normalize-space()='Username']//input")
    private WebElement inputTextFieldEmployeeUserName;

    @FindBy(xpath = "//form//div[normalize-space()='Status']/following-sibling::div")
    private WebElement buttonSelectUserStatus;

    @FindBy(xpath = "//form//div[contains(@class,'oxd-input-group')][normalize-space()='Password']//input")
    private WebElement inputTextFieldPassword;

    @FindBy(xpath = "//form//div[contains(@class,'oxd-input-group')][normalize-space()='Confirm Password']//input")
    private WebElement inputTextFieldConfirmPassword;

    @FindBy(xpath = "//form//button[normalize-space()='Save']")
    private WebElement buttonSaveUser;



    public AdminAddUser(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    private void selectUser(String name){
        DriverFactory.type(inputTextFieldEmployeeName, name);
        WebElement actualUser = DriverFactory.findBy(By.xpath(
            "//div[@class='oxd-autocomplete-option'][normalize-space()='" + name + "']"
        ));

        DriverFactory.click(actualUser);
    }

    private void selectUserType(String type){
        DriverFactory.click(buttonSelectUserRole);
        WebElement userType = DriverFactory.findBy(By.xpath("//div[@class='oxd-select-option']" +
            "[normalize-space()='" + type + "']"));
        DriverFactory.click(userType);
    }

    private void selectUserStatus(String status){
        DriverFactory.click(buttonSelectUserStatus);
        WebElement userType = DriverFactory.findBy(By.xpath("//div[@class='oxd-select-option']" +
                "[normalize-space()='" + status + "']"));
        DriverFactory.click(userType);
    }

    public void saveUser(AdminUser user){
        selectUserType(user.getRole());
        selectUser(user.getEmployeeFirstName() + " " + user.getEmployeeLastName());
        selectUserStatus(user.getStatus());
        DriverFactory.type(inputTextFieldEmployeeUserName, user.getUsername());
        DriverFactory.type(inputTextFieldPassword, user.getPassword());
        DriverFactory.type(inputTextFieldConfirmPassword, user.getPassword());
        DriverFactory.submit(buttonSaveUser);
    }
}
