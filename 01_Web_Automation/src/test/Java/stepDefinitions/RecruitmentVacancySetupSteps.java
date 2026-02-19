package stepDefinitions;

import context.TestContext;
import context.TestRunContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RecruitmentAddVacancyPage;
import pages.RecruitmentPage;
import pages.RecruitmentVacancyPage;
import pages.component.Components;
import testdata.Vacancy;

import static org.testng.Assert.assertTrue;

public class RecruitmentVacancySetupSteps {

    private final TestContext context;
    private final TestRunContext testRunContext;

    public RecruitmentVacancySetupSteps(TestRunContext testRunContext, TestContext context){
        this.testRunContext = testRunContext;
        this.context = context;
    }

    @When("the admin navigates to Recruitment")
    public void navigateRecruitment(){
        context.components().gotoRecruitment();
        context.recruitmentPage().waitUntilLoaded();


    }

    @Then("the admin should see the Recruitment page")
    public void verifyRecruitment(){
        RecruitmentPage recruitmentPage = context.recruitmentPage();
        assertTrue(recruitmentPage.isLoaded(), "Recruitment page not loaded");
    }

    @When("the admin clicks Vacancies")
    public void clickVacancies(){
        RecruitmentPage recruitmentPage = context.recruitmentPage();
        recruitmentPage.openVacancyPage();
        context.vacancyPage().waitUntilLoaded();

    }

    @Then("the vacancy page should be displayed")
    public void verifyVacanciesList(){
        RecruitmentVacancyPage vacancyPage = context.vacancyPage();
        assertTrue(vacancyPage.isLoaded(), "Vacancy page not loaded");
    }

    @When("the admin adds vacancy")
    public void addVacancy(){
        context.vacancyPage().addVacancy();
        context.addVacancyPage().waitUntilLoaded();
    }

    @Then("the save vacancy page should be displayed")
    public void verifyVacancySavePage(){
        RecruitmentAddVacancyPage addVacancyPage = context.addVacancyPage();
        assertTrue(addVacancyPage.isLoaded(), "Save Vacancy page not loaded");
    }

    @When("the admin enters vacancy details and saves")
    public void saveVacancy(){
        Vacancy vacancy = Vacancy.fromJson("vacancy_happy_path.json", testRunContext);
        context.addVacancyPage().createVacancy(vacancy);
    }
}
