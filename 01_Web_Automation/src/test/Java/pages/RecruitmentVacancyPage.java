package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class RecruitmentVacancyPage {

    @FindBy(xpath = "//button[normalize-space()= 'Add']")
    private WebElement buttonAddVacancy;

    public RecruitmentVacancyPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public WebElement getVacancy(String vacancy){
        By locator = By
                .xpath("//div[@class='oxd-table-card']//div[normalize-space(.)='" + vacancy + "']");
        return DriverFactory.findBy(locator);
    }

    public void addVacancy(){
        DriverFactory.click(buttonAddVacancy);
    }
}
