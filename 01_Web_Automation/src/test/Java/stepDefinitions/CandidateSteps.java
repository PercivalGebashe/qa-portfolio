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

    public CandidateSteps(){
        testRunContext = new TestRunContext();
        context = new TestContext();
    }

    @When("the admin adds a candidate")
    public void addCandidate(){
        Candidate candidate = Candidate.fromJson("candidate_happy_path.json", testRunContext);
        context.components().clickTab("recruitment");
        context.recruitmentPage().openCandidatesPage();
        context.addCandidatePage().saveCandidate(candidate);
    }
}
