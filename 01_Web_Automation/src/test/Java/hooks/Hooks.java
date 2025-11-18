package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import util.DriverFactory;

public class Hooks {


    @Before
    public void setUp(){
        DriverFactory.setDriver();
    }

    @After
    public void tearDown(){
        DriverFactory.tearDownDriver();
    }
}
