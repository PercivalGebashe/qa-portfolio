package tests.base;

import client.RequestSpecFactory;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected RequestSpecification requestSpec;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        requestSpec = RequestSpecFactory.create();
    }

}
