package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance(){
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/extent/extent-report" +
                    DriverFactory.getCurrentTimeStamp() + ".html");

            reporter.config().setReportName("End To End Orange HRM Hiring Happy Path");
            reporter.config().setDocumentTitle("Automation Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }

        return extent;
    }
}
