package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class AdminJobTitlesPage {

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement buttonAddTitle;

    public AdminJobTitlesPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public WebElement getCategory(String titleName){
        By locator = By.xpath("//div[@class='oxd-table-card'][normalize-space() = '" + titleName + "']");
        return DriverFactory.findBy(locator);
    }

    public void addJobTitle(){
        DriverFactory.click(buttonAddTitle);
    }
}
