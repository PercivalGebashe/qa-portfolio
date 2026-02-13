package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class PimPage {

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement buttonAddUser;

    @FindBy(xpath = "//nav[@aria-label = 'Topbar Menu']//li[normalize-space()='Add Employee']")
    private WebElement navAddEmployee;

    @FindBy(xpath = "//nav[@aria-label = 'Topbar Menu']//li[normalize-space()='Employee List']")
    private WebElement navEmployeeList;

    public PimPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void openAddEmployeePage(){
        DriverFactory.click(navAddEmployee);
    }

    public void openEmployeeListPage(){
        DriverFactory.click(navEmployeeList);
    }

    public void AddEmployee(){
        DriverFactory.click(buttonAddUser);
    }


}
