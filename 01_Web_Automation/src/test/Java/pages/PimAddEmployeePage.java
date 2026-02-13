package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testdata.AdminUser;
import utils.DriverFactory;

public class PimAddEmployeePage {

    @FindBy(xpath = "//form//div[@class='oxd-input-group']//input[@name='firstName']")
    private WebElement inputTextFieldFirstEmployeeName;

    @FindBy(xpath = "//form//div[@class='oxd-input-group']//input[@name='lastName']")
    private WebElement inputTextFieldEmployeeLastName;

    @FindBy(xpath = "//form//button[normalize-space()='Save']")
    private WebElement buttonSaveEmployee;

    @FindBy(xpath = "//form//div[contains(@class, 'oxd-input-group')][normalize-space()='Employee Id']//input")
    private WebElement inputFieldEmployeeId;


    public PimAddEmployeePage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void saveEmployee(AdminUser user){
        DriverFactory.type(inputTextFieldFirstEmployeeName, user.getEmployeeFirstName());
        DriverFactory.type(inputTextFieldEmployeeLastName, user.getEmployeeLastName());
        DriverFactory.submit(buttonSaveEmployee);
    }

    public String getEmployeeId(){
        return DriverFactory.getAttribute(inputFieldEmployeeId, "value");
    }


}
