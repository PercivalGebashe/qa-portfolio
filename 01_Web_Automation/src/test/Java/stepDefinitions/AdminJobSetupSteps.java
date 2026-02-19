package stepDefinitions;

import context.TestContext;
import context.TestRunContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminAddJobTitlePage;
import pages.AdminJobTitlesPage;
import pages.AdminPage;
import testdata.JobTitle;

import static org.testng.Assert.assertTrue;

public class AdminJobSetupSteps {

    private final TestContext context;
    private final TestRunContext testRunContext;

    public AdminJobSetupSteps(TestRunContext testRunContext, TestContext context){
        this.testRunContext = testRunContext;
        this.context = context;
    }

    @When("the user navigates to Admin")
    public void navigateToAdmin(){
        context.components().gotoAdmin();
        context.adminPage().waitUntilLoaded();
    }

    @Then("the user should see the Admin page")
    public void adminPage(){
        AdminPage adminPage = context.adminPage();
        assertTrue(adminPage.isLoaded(), "Admin page not loaded");
    }

    @When("the user clicks Job")
    public void clickJob(){
        AdminPage adminPage = context.adminPage();
        adminPage.openJobMenu();
        adminPage.jobMenuOptionsDisplayed();

    }

    @When("the user selects Job Titles")
    public void selectJobTitle(){
        context.adminPage().openJobTitle();
        AdminJobTitlesPage jobTitlesPage = context.jobTitlesPage();
        jobTitlesPage.waitUntilLoaded();

    }

    @Then("the job title page should be displayed")
    public void titleListDisplayed(){
        AdminJobTitlesPage jobTitlesPage = context.jobTitlesPage();
        assertTrue(jobTitlesPage.isLoaded(), "Job Titles Page not loaded");
    }

    @When("the user clicks the Add button")
    public void addTitle(){
        AdminJobTitlesPage jobTitlesPage = context.jobTitlesPage();
        jobTitlesPage.addJobTitle();
        AdminAddJobTitlePage addJobTitlePage = context.addJobTitlePage();
        addJobTitlePage.waitUntilLoaded();
    }

    @Then("the user should see the Save Job Title page")
    public void verifySaveJobTitlePage(){
        AdminAddJobTitlePage addJobTitlePage = context.addJobTitlePage();
        assertTrue(addJobTitlePage.isLoaded(), "Save Job Title page not loaded");
    }

    @When("the user enters job title details and saves")
    public void saveJobTitle(){
        JobTitle title = JobTitle.fromJson("job_title_happy_path.json", testRunContext);
        AdminAddJobTitlePage addJobTitlePage = context.addJobTitlePage();
        addJobTitlePage.saveJobTitle(title);
    }
}
