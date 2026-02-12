package stepDefinitions;

import context.TestContext;
import context.TestRunContext;
import io.cucumber.java.en.When;
import testdata.Vacancy;

public class VacancySteps {

    private final TestContext context;
    private final TestRunContext testRunContext;

    public VacancySteps(TestRunContext testRunContext){
        this.testRunContext = testRunContext;
        context = new TestContext();
    }

    public VacancySteps(){
        context = new TestContext();
        testRunContext = new TestRunContext();
    }

    @When("the admin creates a vacancy")
    public void createVacancy(){
        Vacancy vacancy = Vacancy.fromJson("vacancy_happy_path.json", testRunContext);

        context.components().clickTab("recruitment");
        context.recruitmentPage().openVacancyPage();
        context.vacancyPage().addVacancy();
        context.addVacancyPage().createVacancy(vacancy);
    }
}
