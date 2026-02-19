package stepDefinitions;

import context.TestContext;
import context.TestRunContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RecruitmentAddCandidatePage;
import pages.RecruitmentCandidateActionsPage;
import pages.RecruitmentCandidatesPage;
import testdata.Candidate;

import static org.testng.Assert.assertTrue;

public class RecruitmentCandidateSetupSteps {

    private final TestContext context;
    private final TestRunContext testRunContext;

    public RecruitmentCandidateSetupSteps(TestRunContext testRunContext, TestContext context){
        this.testRunContext = testRunContext;
        this.context = context;
    }

    @When("the admin clicks Candidates")
    public void clickCandidates(){
        context.recruitmentPage().openCandidatesPage();
        context.candidatesPage().waitUntilLoaded();
    }

    @Then("the admin should see the candidate page")
    public void verifyCandidates(){
        RecruitmentCandidatesPage candidatesPage = context.candidatesPage();
        assertTrue(candidatesPage.isLoaded(), "Candidate page not loaded");
    }

    @When("the admin adds candidate")
    public void addCandidate(){
        RecruitmentCandidatesPage candidatesPage = context.candidatesPage();
        candidatesPage.addCandidate();
        context.addCandidatePage().waitUntilLoaded();
    }

    @Then("the admin should see the save candidate page")
    public void verifySaveCandidate(){
        RecruitmentAddCandidatePage addCandidatePage = context.addCandidatePage();
        assertTrue(addCandidatePage.isLoaded());
    }

    @When("the admin enters candidate details and saves")
    public void saveCandidate(){
        Candidate candidate = Candidate.fromJson("candidate_happy_path.json", testRunContext);
        context.addCandidatePage().saveCandidate(candidate);

    }

    @Then("the admin should see the candidate actions page")
    public void verifyCandidateActions(){
        RecruitmentCandidateActionsPage candidateActionsPage = context.candidateActionsPage();
        assertTrue(candidateActionsPage.isLoaded(),"Candidate Action page not loaded");
    }
}
