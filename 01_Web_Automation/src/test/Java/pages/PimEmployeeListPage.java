package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class PimEmployeeListPage {

    @FindBy(xpath = "//form//div[contains(@class, 'oxd-input-group')][normalize-space()='Employee Id']//input")
    private WebElement inputFieldEmployeeId;

    @FindBy(xpath = "//form//button[normalize-space()='Search']")
    private WebElement buttonSearch;

    public PimEmployeeListPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public String getEmployeeDetails(String employeeId){
        WebElement details = DriverFactory.findBy(By
                .xpath("//div[contains(@class,'oxd-table-row')]" +
                    "[.//div[normalize-space(text())='" + employeeId + "']]"));

        return DriverFactory.getText(details);
    }

    public void searchEmployeeById(String employeeId){
        DriverFactory.type(inputFieldEmployeeId, employeeId);
        DriverFactory.submit(buttonSearch);
        System.out.println("Done searching");
    }
}
