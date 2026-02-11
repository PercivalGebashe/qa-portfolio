package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.When;

public class CandidateSteps {

    private final TestContext context;

    public CandidateSteps(){
        context = new TestContext();
    }

    @When("the admin adds a candidate")
    public void addCandidate(){
        context.components().clickTab("recruitment");
        context.recruitmentPage().openCandidatesPage();
        context.addCandidatePage().saveCandidate(
            "",
            "",
            "",
            ""
        );
    }
}
