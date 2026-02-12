package stepDefinitions;

import context.TestContext;
import context.TestRunContext;
import io.cucumber.java.en.When;
import pages.component.Components;
import testdata.AdminUser;
import utils.JsonDataLoader;

import java.awt.*;

public class AdminUserSteps {

    private final TestContext context;
    private final TestRunContext testRunContext;

    public AdminUserSteps(TestRunContext testRunContext){
        this.testRunContext = testRunContext;
        context = new TestContext();
    }
    public AdminUserSteps(){
        testRunContext = new TestRunContext();
        context = new TestContext();
    }

    @When("the admin creates a admin user")
    public void createAdminUser(){
        AdminUser user = AdminUser.fromJson("admin_user_template.json", testRunContext);
        Components component = context.components();
        component.clickTab("Admin");
        context.adminPage().openUserManagement();
        context.addUserPage().saveUser(user);
    }
}
