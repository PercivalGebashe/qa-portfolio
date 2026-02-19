package stepDefinitions;

import context.TestContext;
import context.TestRunContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.DashboardPage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;


public class LoginSteps {
    private final TestContext context;

    public LoginSteps(TestContext context){
        this.context = context;
    }

    @Given("the admin user is logged into the system")
    public void adminUserIsLoggedIn(){
        LoginPage loginPage = context.loginPage();
        loginPage.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.login("Admin", "admin123");
        context.dashboardPage().waitUntilLoaded();

    }

    @Then("the user should see the Dashboard")
    public void verifyDashboard(){
        assertTrue(context.dashboardPage().isLoaded(),"Dashboard not loaded");
    }
}