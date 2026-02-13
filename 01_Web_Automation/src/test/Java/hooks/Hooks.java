package hooks;

import context.TestRunContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks {

    private final TestRunContext testRunContext;

    public Hooks(TestRunContext testRunContext){
        this.testRunContext = testRunContext;
    }

    @Before(order = 0)
    public void logReference(){
    }

    @Before(order = 1)
    public void setUp(){
        DriverFactory.setDriver();
    }

    @After(order = 10)
    public void tearDown(){
        DriverFactory.tearDownDriver();
    }
}
