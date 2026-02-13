package stepDefinitions;

import context.TestContext;
import context.TestRunContext;
import io.cucumber.java.en.Given;
import pages.LoginPage;
import testdata.AdminUser;
import utils.DriverFactory;

import static org.testng.Assert.assertTrue;


public class LoginSteps {
    private final TestContext context;
    private final TestRunContext testRunContext;

    public LoginSteps(TestRunContext testRunContext){
        this.testRunContext = testRunContext;
        context = new TestContext();
    }

    @Given("the admin user is logged into the system")
    public void adminUserIsLoggedIn(){
        DriverFactory.openWebsite();
        LoginPage page = context.loginPage();
        assertTrue(page.isLoginFormVisible(), "Login form is not visible");
        page.login("Admin", "admin123");
    }

    @Given("the created admin user is logged into the system")
    public void createdAdminUserIsLoggedIn(){
        AdminUser user = AdminUser.fromJson("admin_user_template.json", testRunContext);
        LoginPage page = context.loginPage();
        assertTrue(page.isLoginFormVisible(), "Login form is not visible");
        page.login(user.getUsername(), user.getPassword());

    }
}