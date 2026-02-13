package hooks;

import com.aventstack.extentreports.*;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import utils.*;

public class ExtentHooks {

    private final WebDriver driver;
    private static final ExtentReports extent = ExtentManager.getInstance();

    public ExtentHooks() {
        driver = DriverFactory.getDriver();
    }

    @BeforeStep
    public void logStep(Scenario scenario) {
        ExtentTestManager.getTest()
            .info("Step executed: " + scenario.getName());
    }


    @Before(order = 2)
    public void beforeScenario(Scenario scenario) {

        ExtentTest test =
            extent.createTest(scenario.getName());

        ExtentTestManager.setTest(test);
    }

    @After(order = 2)
    public void afterScenario(Scenario scenario) {

        ExtentTest test = ExtentTestManager.getTest();

        if (scenario.isFailed()) {

            String screenshot =
                    ScreenshotUtils.captureBase64(driver);

            test.fail("Scenario Failed")
                    .addScreenCaptureFromBase64String(screenshot);

        } else {
            test.pass("Scenario Passed");
        }

        extent.flush();
    }
}
