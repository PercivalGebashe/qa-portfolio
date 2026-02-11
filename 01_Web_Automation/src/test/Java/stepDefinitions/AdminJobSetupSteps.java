package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.When;

public class AdminJobSetupSteps {

    private final TestContext context;

    public AdminJobSetupSteps(){
        context = new TestContext();
    }

    @When("the admin creates a job category {string}")
    public void createJobCategory(String category){
        context.components().clickTab("admin");
        context.adminPage().openJobCategories();
        context.jobCategoriesPage().addJobCategory();
        context.addJobCategoryPage().saveJobCategory(category);
    }

    @When("the admin creates a job title {string}")
    public void createJobTitle(String title){
        context.components().clickTab("admin");
        context.adminPage().openJobCategories();
        context.jobTitlesPage().addJobTitle();
        context.addJobTitlePage().saveJobCategory(title);
    }
}
