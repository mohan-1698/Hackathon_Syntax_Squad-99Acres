package com.hackathon.hcl.Acres_Syntax_Squad.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.hackathon.hcl.Acres_Syntax_Squad.utils.ExtentUtil;

public class ExtentListener implements ITestListener {

    // Extent Report Instance
    private static ExtentReports extent =
            ExtentUtil.getReportInstance();

    // Thread Safe Test Object
    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    // Before Suite Execution
    @Override
    public void onStart(ITestContext context) {

        System.out.println("Test Execution Started");
    }

    // Before Each Test
    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(
                        result.getMethod().getMethodName()
                );

        test.set(extentTest);

        System.out.println("Test Started : "
                + result.getMethod().getMethodName());
    }

    // On Test Pass
    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");

        System.out.println("Test Passed : "
                + result.getMethod().getMethodName());
    }

    // On Test Failure
    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        System.out.println("Test Failed : "
                + result.getMethod().getMethodName());
    }

    // On Test Skipped
    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");

        System.out.println("Test Skipped : "
                + result.getMethod().getMethodName());
    }

    // After Suite Execution
    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println("Extent Report Generated");
    }
}