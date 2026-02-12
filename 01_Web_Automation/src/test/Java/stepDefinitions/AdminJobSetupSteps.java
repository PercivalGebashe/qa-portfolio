package stepDefinitions;

import context.TestContext;
import context.TestRunContext;
import io.cucumber.java.en.When;
import testdata.JobTitle;

public class AdminJobSetupSteps {

    private final TestContext context;
    private final TestRunContext testRunContext;

    public AdminJobSetupSteps(TestRunContext testRunContext){
        this.testRunContext = testRunContext;
        context = new TestContext();
    }

    public AdminJobSetupSteps() {
        testRunContext = new TestRunContext();
        context = new TestContext();
    }

    @When("the admin creates a job category {string}")
    public void createJobCategory(String category){
        context.components().clickTab("admin");
        context.adminPage().openJobCategories();
        context.jobCategoriesPage().addJobCategory();
        context.addJobCategoryPage().saveJobCategory(category);
    }

    @When("the admin creates a job title")
    public void createJobTitle(){
        JobTitle title = JobTitle.fromJson("job_title_happy_path.json", testRunContext);
        context.components().clickTab("admin");
        context.adminPage().openJobCategories();
        context.jobTitlesPage().addJobTitle();
        context.addJobTitlePage().saveJobCategory(title);
    }
}
