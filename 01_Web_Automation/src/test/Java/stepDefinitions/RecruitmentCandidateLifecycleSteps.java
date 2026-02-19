package stepDefinitions;

import context.TestContext;
import context.TestRunContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RecruitmentCandidateActionsPage;
import pages.RecruitmentChangeCandidateStatusPage;
import testdata.Interview;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RecruitmentCandidateLifecycleSteps {

    private final TestContext context;
    private final TestRunContext testRunContext;

    public RecruitmentCandidateLifecycleSteps(TestRunContext testRunContext, TestContext context){
        this.testRunContext = testRunContext;
        this.context = context;
    }

    @When("the admin shortlists the candidate")
    public void shortlistCandidate(){
        RecruitmentCandidateActionsPage candidateActionsPage = context.candidateActionsPage();
        candidateActionsPage.waitUntilLoaded();
        context.candidateActionsPage().shortlistCandidate();
        context.changeCandidateStatusPage().waitUntilLoaded();
    }

    @Then("the admin should see the change candidate status page")
    public void verifyChangeCandidateStatus(){
        RecruitmentChangeCandidateStatusPage page = context.changeCandidateStatusPage();
        assertTrue(page.isLoaded(), "Candidate Status Change page not loaded");
    }

    @When("the admin saves the candidate details")
    public void saveCandidateDetails(){
        RecruitmentChangeCandidateStatusPage page = context.changeCandidateStatusPage();
        page.waitUntilLoaded();
        page.saveDetails();
    }

    @When("the admin schedules an interview")
    public void scheduleInterview(){
        RecruitmentCandidateActionsPage candidateActionsPage = context.candidateActionsPage();
        candidateActionsPage.waitUntilLoaded();
        candidateActionsPage.scheduleInterview();
        context.changeCandidateStatusPage().waitUntilLoaded();
    }

    @When("the admin enters interview details and saves")
    public void saveCandidateInterviewDetails(){
        context.changeCandidateStatusPage().waitUntilLoaded();
        Interview interview = Interview.fromJson("interview_happy_path.json", testRunContext);
        context.changeCandidateStatusPage().saveInterview(interview);
    }

    @When("the admin marks the interview as passed")
    public void markInterviewPassed(){
        RecruitmentCandidateActionsPage candidateActionsPage = context.candidateActionsPage();
        candidateActionsPage.waitUntilLoaded();
        candidateActionsPage.markInterviewPassed();
        context.changeCandidateStatusPage().waitUntilLoaded();
    }

    @When("the admin offers the job to the candidate")
    public void offerJob(){
        context.candidateActionsPage().offerJob();
        context.changeCandidateStatusPage().waitUntilLoaded();
    }

    @When("the admin hires the candidate")
    public void hireCandidate(){
        context.candidateActionsPage().hireCandidate();
        context.changeCandidateStatusPage().waitUntilLoaded();
    }

    @Then("the candidate application status should be {string}")
    public void candidateApplicationStatus(String expectedStatus){
        assertTrue(context.candidateActionsPage().isLoaded(),"Candidate Actions page not loaded");
        String actualStatus = context.candidateActionsPage().getCurrentStatus().split(":")[1].strip();
        assertEquals(actualStatus, expectedStatus, "Unexpected candidate application status"
        );
    }
}
