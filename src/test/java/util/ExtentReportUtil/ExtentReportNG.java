package util.ExtentReportUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import util.TestConfigReader;

/**
 *
 * This test class works as Utility Class for ExtentReport Generation.
 *
 * @author Swarnaprabha Ghosh
 */

public class ExtentReportNG extends TestConfigReader {

    static ExtentReports extentReports;
    public static ExtentReports setReport(){
        String path = ProjectWorkingDirectory+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Java Selenium Tests");
        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setTheme(Theme.STANDARD);

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Product: NBA Site ","Version: Basic");
        extentReports.setSystemInfo("Platform" ,OSName);
        extentReports.setSystemInfo("OS version" ,OSVersion);
        extentReports.setSystemInfo("Environment", "QA");
        return extentReports;
    }
}
