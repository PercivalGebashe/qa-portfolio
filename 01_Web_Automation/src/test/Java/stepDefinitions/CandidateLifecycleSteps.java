package stepDefinitions;

import context.TestContext;
import context.TestRunContext;
import io.cucumber.java.en.When;
import testdata.Interview;
import utils.JsonDataLoader;

public class CandidateLifecycleSteps {

    private final TestContext context;
    private final TestRunContext testRunContext;

    public CandidateLifecycleSteps(TestRunContext testRunContext){
        context = new TestContext();
        this.testRunContext = testRunContext;
    }

    @When("the candidate is shortlisted")
    public void shortlistCandidate(){
        context.candidateActionsPage().shortlistCandidate();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("the interview is scheduled for the candidate")
    public void scheduleInterview() {
        Interview interview = Interview.fromJson("interview_happy_path.json", testRunContext);
        context.candidateActionsPage().scheduleInterview(interview);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("the interview is marked as passed")
    public void markInterviewPassed() {
        context.candidateActionsPage().markInterviewPassed();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("the job is offered to the candidate")
    public void offerJob() {
        context.candidateActionsPage().offerJob();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("the candidate is hired")
    public void hireCandidate() {
        context.candidateActionsPage().hireCandidate();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
