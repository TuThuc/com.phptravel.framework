package com.phptravel.reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.phptravel.commons.GlobalConstants;

import java.util.HashMap;
import java.util.Map;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    static ExtentReports extent = ExtentManager.createExtentReports();
    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants.getGlobalConstants().getExtentReport());
        reporter.config().setReportName("PHPTravel HTML Report");
        reporter.config().setDocumentTitle("PHPTravel HTML Report");
        reporter.config().setTimelineEnabled(true);
        reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.STANDARD);

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Company", "Automation FC");
        extentReports.setSystemInfo("Project", "PHPTravel");
        extentReports.setSystemInfo("Team", "Automation Testing");
        extentReports.setSystemInfo("JDK version", GlobalConstants.getGlobalConstants().getJavaVersion());
        return extentReports;
    }
    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }
}
