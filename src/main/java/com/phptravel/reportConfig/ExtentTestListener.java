package com.phptravel.reportConfig;

import com.aventstack.extentreports.Status;
import com.phptravel.commons.BaseTest;
import com.phptravel.ultilities.excelultils.ExcelUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.phptravel.reportConfig.ExtentManager.getTest;

public class ExtentTestListener implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentManager.extentReports.flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        getTest().log(Status.PASS,"Test passed");
        //Update the test result on excel sheet
        ExcelUtil.setCellData("Passed", ExcelUtil.rowNumber, ExcelUtil.columnNumber);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult)  {
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriverInstance();
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        getTest().log(Status.FAIL, "Test Failed", getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
        //Update the test result on excel sheet
        ExcelUtil.setCellData("Failed", ExcelUtil.rowNumber, ExcelUtil.columnNumber);
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        getTest().log(Status.SKIP, "Test Skipped");
        //Update the test result on excel sheet
        ExcelUtil.setCellData("Skipped", ExcelUtil.rowNumber, ExcelUtil.columnNumber);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        getTest().log(Status.FAIL, "Test Failed with percentage" + getTestMethodName(iTestResult));
    }
}
