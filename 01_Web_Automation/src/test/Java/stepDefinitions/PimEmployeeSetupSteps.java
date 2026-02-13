package stepDefinitions;

import context.TestContext;
import context.TestRunContext;
import io.cucumber.java.en.When;
import pages.PimAddEmployeePage;
import pages.PimPage;
import pages.PimPersonalDetailsPage;
import pages.component.Components;
import testdata.AdminUser;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class PimEmployeeSetupSteps {

    private final TestContext context;
    private final TestRunContext testRunContext;

    public PimEmployeeSetupSteps(TestRunContext testRunContext){
        this.testRunContext = testRunContext;
        context = new TestContext();
    }

    @When("the admin creates an employee")
    public void createEmployee(){
        AdminUser user = AdminUser.fromJson("admin_user_template.json", testRunContext);
        Components component = context.components();
        PimPage pimPage = context.pimPage();
        PimAddEmployeePage addEmployeePage = context.addEmployeePage();
        PimPersonalDetailsPage personalDetailsPage = context.personDetailsPage();

        component.clickTab("pim");
        pimPage.openAddEmployeePage();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String employeeId = addEmployeePage.getEmployeeId();
        System.out.println("Emp Id: " + employeeId);

        addEmployeePage.saveEmployee(user);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String employeeIdSaved = personalDetailsPage.getEmployeeId();
        System.out.println("Emp Id Saved: " + employeeIdSaved);
        assertEquals(employeeId, employeeIdSaved, "Employee IDs do not match");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        component.clickTab("pim");
        context.pimPage().openEmployeeListPage();
        context.employeeListPage().searchEmployeeById(employeeId);
        String employeeDetails = context.employeeListPage().getEmployeeDetails(employeeId);
        System.out.println("Details: " + Arrays.toString(employeeDetails.split(" ")));
    }
}
