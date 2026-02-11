package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.When;

public class CandidateLifecycleSteps {

    private final TestContext context;

    public CandidateLifecycleSteps(){
        context = new TestContext();
    }

    @When("the candidate is shortlisted")
    public void shortlistCandidate(){
        context.candidateActionsPage().shortlistCandidate();
    }

    @When("the interview is scheduled for the candidate")
    public void scheduleInterview() {
        context.candidateActionsPage().scheduleInterview();
    }

    @When("the interview is marked as passed")
    public void markInterviewPassed() {
        context.candidateActionsPage().markInterviewPassed();
    }

    @When("the job is offered to the candidate")
    public void offerJob() {
        context.candidateActionsPage().offerJob();
    }

    @When("the candidate is hired")
    public void hireCandidate() {
        context.candidateActionsPage().hireCandidate();
    }
}
