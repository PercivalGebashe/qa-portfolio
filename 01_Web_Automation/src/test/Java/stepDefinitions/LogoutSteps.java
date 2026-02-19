package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Then;

public class LogoutSteps {

    private final TestContext context;

    public LogoutSteps(TestContext context){
        this.context = context;
    }

    @Then("the user logs out")
    public void logout(){
        context.components().logout();
    }

    @Then("the user should see the login page")
    public void verifyLoginPage(){

    }
}
