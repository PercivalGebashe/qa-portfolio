package context;

import pages.*;
import pages.component.Components;

public class TestContext {

    public TestContext(){

    }

    public LoginPage loginPage() {
        return new LoginPage();
    }

    public AdminPage adminPage() {
        return new AdminPage();
    }

    public AdminJobCategoriesPage jobCategoriesPage() {
        return new AdminJobCategoriesPage();
    }

    public AdminAddJobCategoryPage addJobCategoryPage(){
        return new AdminAddJobCategoryPage();
    }

    public AdminJobTitlesPage jobTitlesPage(){
        return new AdminJobTitlesPage();
    }

    public AdminAddJobTitlePage addJobTitlePage(){
        return new AdminAddJobTitlePage();
    }

    public RecruitmentPage recruitmentPage(){
        return new RecruitmentPage();
    }

    public RecruitmentVacancyPage vacancyPage(){
        return new RecruitmentVacancyPage();
    }

    public RecruitmentAddVacancyPage addVacancyPage(){
        return new RecruitmentAddVacancyPage();
    }

    public RecruitmentCandidatesPage candidatesPage(){
        return new RecruitmentCandidatesPage();
    }

    public RecruitmentAddCandidatePage addCandidatePage(){
        return new RecruitmentAddCandidatePage();
    }

    public CandidateActionsPage candidateActionsPage(){
        return new CandidateActionsPage();
    }

    public Components components() {
        return new Components();
    }
}
