package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class PimPersonalDetailsPage {

    @FindBy(xpath = "//form//div[contains(@class, 'oxd-input-group')][normalize-space()='Employee Id']//input")
    private WebElement inputFieldEmployeeId;

    @FindBy(xpath = "//div[@class='oxd-form-actions'][.//p[normalize-space()='* Required']]//button")
    private WebElement buttonSaveDetails;

    public PimPersonalDetailsPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public String getEmployeeId(){
        return DriverFactory.getAttribute(inputFieldEmployeeId, "value");
    }

    public void update(){
        DriverFactory.submit(buttonSaveDetails);
    }
}
