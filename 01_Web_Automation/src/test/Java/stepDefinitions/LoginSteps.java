package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;


public class LoginSteps {
    private final TestContext context;

    public LoginSteps(){
        context = new TestContext();
    }

    @Given("the admin user is logged into the system")
    public void adminUserIsLoggedIn(){
        LoginPage page = context.loginPage();
        assertTrue(page.isLoginFormVisible(), "Login form is not visible");
        page.login("Admin", "admin123");
    }
}