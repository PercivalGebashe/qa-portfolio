package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentManager;
import utils.ExtentTestManager;

public class ExtentHooks {

    private static final ExtentReports extent = ExtentManager.getInstance();

    public ExtentHooks() {
    }

    @Before(order = 2)
    public void beforeScenario(Scenario scenario) {

        ExtentTest test =
            extent.createTest(scenario.getName());

        ExtentTestManager.setTest(test);
    }

    @AfterAll()
    public static void tearDown(){
        ExtentManager.getInstance().flush();
    }
}
