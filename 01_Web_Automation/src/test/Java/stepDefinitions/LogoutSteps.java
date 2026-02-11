package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Then;

public class LogoutSteps {

    private final TestContext context;

    public LogoutSteps(){
        context = new TestContext();
    }

    @Then("the user logs out")
    public void logout(){
        context.components().logout();
    }
}
