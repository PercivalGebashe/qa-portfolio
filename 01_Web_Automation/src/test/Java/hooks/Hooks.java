package hooks;

import core.DriverFactory;
import core.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before(order = 0)
    public void logReference(){

    }

    @Before(order = 1)
    public void setUp(){
        DriverManager.setDriver(DriverFactory.createDriver());
    }

    @After(order = 10)
    public void tearDown(){
        if(DriverManager.getDriver() != null){
            DriverManager.getDriver().quit();
            DriverManager.removeDriver();
        }
    }
}
