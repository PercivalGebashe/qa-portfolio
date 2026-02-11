package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.When;

public class VacancySteps {

    private final TestContext context;

    public VacancySteps(){
        context = new TestContext();
    }

    @When("the admin creates a vacancy")
    public void createVacancy(){
        context.components().clickTab("recruitment");
        context.recruitmentPage().openVacancyPage();
        context.vacancyPage().addVacancy();
        context.addVacancyPage().createVacancy(
                "some name",
                "some title",
                "some hiring manager",
                "11");
    }
}
