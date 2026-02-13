package stepDefinitions;

import context.TestContext;
import context.TestRunContext;
import io.cucumber.java.en.When;
import testdata.Candidate;

public class CandidateSteps {

    private final TestContext context;
    private final TestRunContext testRunContext;

    public CandidateSteps(TestRunContext testRunContext){
        context = new TestContext();
        this.testRunContext = testRunContext;
    }

    @When("the admin adds a candidate")
    public void addCandidate(){
        Candidate candidate = Candidate.fromJson("candidate_happy_path.json", testRunContext);
        context.components().clickTab("recruitment");
        context.recruitmentPage().openCandidatesPage();
        context.recruitmentPage().addCandidate();
        context.addCandidatePage().saveCandidate(candidate);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
