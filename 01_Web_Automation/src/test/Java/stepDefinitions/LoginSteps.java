package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import util.DriverFactory;

import static org.testng.Assert.assertTrue;

public class LoginSteps {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;


    @Given("the user is on the OrangeHRM login page")
    public void openOrangeORMLoginPage() {
        loginPage = new LoginPage();
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/auth/login");

    }

    @When("the user enters the username {string} and password {string}")
    public void theUserEntersTheUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("clicks on the login button")
    public void clicksOnTheLoginButton() {
        loginPage.submit();
    }

    @Then("the user should be directed to the Dashboard page")
    public void theUserShouldBeDirectedToTheDashboardPage() {

    }

    @And("the title of the page should be OrangeHRM")
    public void theTitleOfThePageShouldBeOrangeHRM() {

    }

    @Then("an error message {string} should be displayed")
    public void displayError(String msg) {

    }

    @Given("the user is Logged in successfully")
    public void theUserIsLoggedInSuccessfully() {
        loginPage = new LoginPage();
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/auth/login");
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.submit();
        assertTrue(loginPage.isLoginFormVisible());
    }

    @When("the user clicks on the profile dropdown")
    public void theUserClicksOnTheProfileDropdown() {
        dashboardPage = new DashboardPage();
        dashboardPage.clickProfile();
    }

    @And("selects the Logout option")
    public void selectsTheLogoutOption() {
        dashboardPage.clickLogout();
    }

    @Then("the user should be redirected to the login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        assertTrue(loginPage.isLoginFormVisible());

    }

    @And("the login form should be visible")
    public void theLoginFormShouldBeVisible() {
        assertTrue(loginPage.isLoginFormVisible(), "Login page not displayed after logout");
    }
}
