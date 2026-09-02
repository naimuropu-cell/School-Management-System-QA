package listeners;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseTest;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        File reportDir = new File("reports");
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
        spark.config().setReportName("School Management System - Automation Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Naimur Rahman");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
        extent.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());

        Object instance = result.getInstance();
        if (instance instanceof BaseTest) {
            WebDriver driver = getDriverFromInstance(instance);
            if (driver != null) {
                String path = ScreenshotUtil.captureScreenshot(
                        driver, result.getMethod().getMethodName());
                if (path != null) {
                    try {
                        test.addScreenCaptureFromPath(path);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        extent.flush();
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    private WebDriver getDriverFromInstance(Object instance) {

        try {
            java.lang.reflect.Field field = BaseTest.class.getDeclaredField("driver");
            field.setAccessible(true);
            return (WebDriver) field.get(instance);
        } catch (Exception e) {
            return null;
        }
    }

}
