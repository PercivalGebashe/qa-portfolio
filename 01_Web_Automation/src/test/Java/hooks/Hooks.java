package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks {


    @Before
    public void setUp(){
        DriverFactory.setDriver();
        DriverFactory.openWebsite();
    }

    @After
    public void tearDown(){
        DriverFactory.tearDownDriver();
    }
}
