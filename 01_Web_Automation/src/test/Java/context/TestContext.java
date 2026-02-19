package context;

import core.DriverManager;
import pages.*;
import pages.component.Components;

public class TestContext {

    private final DriverManager driverManager;

    public TestContext(DriverManager driverManager){
        this.driverManager = driverManager;

    }

    public LoginPage loginPage() {
        return new LoginPage(driverManager);
    }

    public AdminPage adminPage() {
        return new AdminPage(driverManager);
    }

    public AdminJobTitlesPage jobTitlesPage(){
        return new AdminJobTitlesPage(driverManager);
    }

    public BasePage basePage(){
        return new BasePage(driverManager);
    }

    public AdminAddJobTitlePage addJobTitlePage(){
        return new AdminAddJobTitlePage(driverManager);
    }

    public RecruitmentPage recruitmentPage(){
        return new RecruitmentPage(driverManager);
    }

    public RecruitmentVacancyPage vacancyPage(){
        return new RecruitmentVacancyPage(driverManager);
    }

    public RecruitmentAddVacancyPage addVacancyPage(){
        return new RecruitmentAddVacancyPage(driverManager);
    }

    public RecruitmentCandidatesPage candidatesPage(){
        return new RecruitmentCandidatesPage(driverManager);
    }

    public RecruitmentAddCandidatePage addCandidatePage(){
        return new RecruitmentAddCandidatePage(driverManager);
    }

    public RecruitmentCandidateActionsPage candidateActionsPage(){
        return new RecruitmentCandidateActionsPage(driverManager);
    }

    public Components components() {
        return new Components(driverManager);
    }

    public DashboardPage dashboardPage() {
        return new DashboardPage(driverManager);
    }

    public RecruitmentChangeCandidateStatusPage changeCandidateStatusPage() {
        return new RecruitmentChangeCandidateStatusPage(driverManager);
    }
}
