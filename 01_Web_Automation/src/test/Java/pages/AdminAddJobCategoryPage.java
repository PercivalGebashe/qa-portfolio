package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class AdminAddJobCategoryPage {

    @FindBy(xpath = "//form//input")
    private WebElement inputTextFieldJobCategoryName;

    @FindBy(xpath = "//form//button[text()=' Save ']")
    private WebElement buttonSaveJobCategory;


    public AdminAddJobCategoryPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void saveJobCategory(String name){
        DriverFactory.type(inputTextFieldJobCategoryName, name);
        DriverFactory.click(buttonSaveJobCategory);
    }
}
