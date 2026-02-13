package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;

public class CandidateStatusSteps {

    private final TestContext context;

    public CandidateStatusSteps(){
        context = new TestContext();
    }

    @Then("the candidate application status should be {string}")
    public void candidateApplicationStatus(String expectedStatus){
        String actualStatus = context.candidateActionsPage().getCurrentStatus().split(":")[1].strip();

        assertEquals(
            actualStatus,
            expectedStatus,
            "Unexpected candidate application status"
        );
    }
}
