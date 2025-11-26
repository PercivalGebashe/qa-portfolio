package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.component.Components;
import util.DriverFactory;

import java.util.Objects;

public class DashboardPage{

    public DashboardPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void clickProfile(){
        Objects.requireNonNull(DriverFactory.getWait().until(
            ExpectedConditions.elementToBeClickable(Components.userDropdown)))
                .click();
    }

    public void clickLogout(){
        Objects.requireNonNull(DriverFactory.getWait().until(
            ExpectedConditions.elementToBeClickable(Components.logoutOption)))
                .click();
    }
}
