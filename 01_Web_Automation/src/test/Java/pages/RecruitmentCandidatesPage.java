package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class RecruitmentCandidatesPage {

    @FindBy(xpath = "//button[normalize-space()= 'Add']")
    private WebElement buttonAddCandidate;

    public RecruitmentCandidatesPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public WebElement getCandidate(String candidate){
        By locator = By
                .xpath("//div[@class='oxd-table-card']//div[normalize-space(.)='" + candidate + "']");
        return DriverFactory.findBy(locator);
    }

    public void addCandidate(){
        DriverFactory.click(buttonAddCandidate);
    }
}
