package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.component.Components;
import util.DriverFactory;

public class DashboardPage extends BaseClass{

    public DashboardPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void clickProfile(){
        WebElement userDropdown = DriverFactory.getDriver().findElement(Components.userDropdown);
        userDropdown.click();
    }

    public void clickLogout(){
        WebElement logoutOption = DriverFactory.getDriver().findElement(Components.logoutOption);
        logoutOption.click();
    }
}
