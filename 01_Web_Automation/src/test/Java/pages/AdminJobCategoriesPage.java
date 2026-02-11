package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class AdminJobCategoriesPage {
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement buttonAddCategory;

    public AdminJobCategoriesPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public WebElement getCategory(String categoryName){
        By locator = By.xpath("//div[@class='oxd-table-card'][normalize-space() = '" + categoryName + "']");
        return DriverFactory.findBy(locator);
    }

    public void addJobCategory(){
        DriverFactory.click(buttonAddCategory);
    }
}
