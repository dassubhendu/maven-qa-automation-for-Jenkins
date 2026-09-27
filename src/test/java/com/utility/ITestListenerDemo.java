//package com.utility;
//
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//public class ITestListenerDemo implements ITestListener {
//
//    @Override
//    public void onTestStart(ITestResult result){
//        ExtentReportUtility.createTest(result.getMethod().getMethodName());
//    }
//
//    @Override
//    public void onFinish(ITestContext context){
//        ExtentReportUtility.flushReport();
//    }
//
//}

package com.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerDemo implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportUtility.test.pass("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportUtility.test.fail("Test failed: " + result.getMethod().getMethodName());
        ExtentReportUtility.test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportUtility.test.skip("Test skipped: " + result.getMethod().getMethodName());
    }

}
