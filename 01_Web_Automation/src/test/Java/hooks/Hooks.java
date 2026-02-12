package hooks;

import context.TestRunContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks {

    private final TestRunContext testRunContext;

    public Hooks(){
        testRunContext = new TestRunContext();
    }

    @Before(order = 0)
    public void logReference(){
        System.out.println("Test run Reference: " + testRunContext.getReference());
    }

    @Before
    public void setUp(){
        DriverFactory.setDriver();
    }

    @After
    public void tearDown(){
        DriverFactory.tearDownDriver();
    }
}
