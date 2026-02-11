package pages.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

import java.util.Map;
import static java.util.Map.entry;

public class Components {

    public By userDropdown = By.cssSelector(".oxd-userdropdown");

    public By dropdownMenu = By.cssSelector("ul[role='menu']");

    private final By logoutOption = By.xpath("//a[normalize-space()='Logout']");

    private final Map<String, By> tabs = Map.ofEntries(
            entry("admin", By.xpath("//li/a[normalize-space()='Admin']")),
            entry("pim", By.xpath("//li/a[normalize-space()='PIM']")),
            entry("leave", By.xpath("//li/a[normalize-space()='Leave']")),
            entry("time", By.xpath("//li/a[normalize-space()='Time']")),
            entry("recruitment", By.xpath("//li/a[normalize-space()='Recruitment']")),
            entry("info", By.xpath("//li/a[normalize-space()='My Info']")),
            entry("performance", By.xpath("//li/a[normalize-space()='Performance']")),
            entry("dashboard", By.xpath("//li/a[normalize-space()='Dashboard']")),
            entry("directory", By.xpath("//li/a[normalize-space()='Directory']")),
            entry("maintenance", By.xpath("//li/a[normalize-space()='Maintenance']")),
            entry("claim", By.xpath("//li/a[normalize-space()='Claim']")),
            entry("buzz", By.xpath("//li/a[normalize-space()='My Info']")));


    public void clickTab(String tabName){
        WebElement tab = DriverFactory.findBy(tabs.get(tabName.toLowerCase()));
        DriverFactory.click(tab);
    }

    public void logout(){
        WebElement profileIcon = DriverFactory.findBy(userDropdown);
        DriverFactory.click(profileIcon);
        WebElement logoutOptionEl = DriverFactory.findBy(logoutOption);
        DriverFactory.click(logoutOptionEl);
    }
}
