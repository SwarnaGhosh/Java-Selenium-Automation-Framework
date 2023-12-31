package util.ExtentReportUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.WebDriverUtil;

import java.io.IOException;

/**
 *
 * This test class works as Listeners for ExtentReport.
 *
 * @author Swarnaprabha Ghosh
 */

public class ExtenReportListners implements ITestListener {

    ExtentReports extentReports = ExtentReportNG.setReport();
    ExtentTest extentTest;
    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        extentTest=extentReports.createTest(iTestResult.getMethod().getDescription()+"--"+iTestResult.getInstanceName());
        extentTestThreadLocal.set(extentTest);
        extentTest.log(Status.INFO,"Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        extentTestThreadLocal.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try{
            extentTestThreadLocal.get().fail(iTestResult.getThrowable());
            extentTest.addScreenCaptureFromPath("src/test/resources/ScreenshotsFailedTestCase" + iTestResult.getTestClass().getName() + "."
                    + iTestResult.getMethod().getMethodName() + ".png",iTestResult.getTestName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();
    }
}
