package utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    private static ExtentTest extentTest = null;


    public static void setTest(ExtentTest extentTest1) {
        extentTest = extentTest1;
    }

    public static ExtentTest getTest() {
        return extentTest;
    }
}
