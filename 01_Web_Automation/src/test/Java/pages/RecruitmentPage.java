package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class RecruitmentPage {

    @FindBy(xpath = "//a[normalize-space()='Vacancies']")
    private WebElement vacancies;

    @FindBy(xpath = "//a[normalize-space()='Candidates']")
    private WebElement candidates;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement buttonAddCandidate;

    public RecruitmentPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }


    public void openVacancyPage() {
        DriverFactory.click(vacancies);
    }

    public void openCandidatesPage(){
        DriverFactory.click(candidates);
    }

    public void addCandidate(){
        DriverFactory.click(buttonAddCandidate);
    }
}
