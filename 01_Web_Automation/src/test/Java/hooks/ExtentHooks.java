package hooks;

import com.aventstack.extentreports.*;
import io.cucumber.java.*;
import utils.*;

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
