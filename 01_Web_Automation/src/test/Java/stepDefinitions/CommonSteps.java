package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertTrue;

public class CommonSteps {

    private final TestContext context;

    public CommonSteps(TestContext context){
        this.context = context;
    }

    @Then("a success alert should be displayed")
    public void verifySuccess(){
        assertTrue(context.basePage().successDisplayed(), "Success alert not displayed");
    }
}
