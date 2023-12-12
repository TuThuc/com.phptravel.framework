package com.phptravel.commons;
import java.time.Duration;
import java.util.Random;


import com.phptravel.factoryEnvironment.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BaseTest {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    protected final Log log;
    protected BaseTest() {
        log = LogFactory.getLog(getClass());
    }

    protected WebDriver getBrowserDriver(String envName, String browserName,String serverName, String ipAddress, String portNumber, String osName, String osVersion) {
        switch (envName) {
            case "local":
                driver.set(new LocalFactory(browserName).creatDriver());
                break;
            case "grid":
                driver.set(new GridFactory(browserName, ipAddress, portNumber).creatDriver());
                break;
            case "browserStack":
                driver.set(new BrowserstackFactory(browserName, osName, osVersion).creatDriver());

                break;
            case "sauceLab":
                driver.set(new SaucelabFactory(browserName, osName).creatDriver());
                break;
            case "Lambda":
                driver.set(new LambdaFactory(browserName, osName).creatDriver());
                break;
            default:
                driver.set(new LocalFactory(browserName).creatDriver());

                break;
        }
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.getGlobalConstants().getLongTimeout()));
        driver.get().manage().window().maximize();
        driver.get().get(getAppUrlByServerName(serverName));
        return driver.get();
    }

    private String getAppUrlByServerName(String serverName) {
        System.out.println("Server name: " + serverName);
        EnvironmentList serverList = EnvironmentList.valueOf(serverName.toUpperCase());
        switch (serverList) {
            case DEV:
                return GlobalConstants.getGlobalConstants().getDevAppUrl();
            case TESTING:
                return GlobalConstants.getGlobalConstants().getTestAppUrl();
            case STAGING:
                return GlobalConstants.getGlobalConstants().getStagingAppUrl();
            case PRODUCTION:
                return GlobalConstants.getGlobalConstants().getProductAppUrl();
            default:
                throw new RuntimeException("Server name is invalid");
        }
    }
    public WebDriver getDriverInstance() {
        return this.driver.get();
    }

    protected int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            log.info(" -------------------------- FAILED -------------------------- ");
            pass = false;

            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            log.info(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            log.info(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected void closeBrowserAndDriver() {
        driver.get().quit();
    }

    protected String getCurrentDate() {
        DateTime nowUTC = new DateTime();
        int day = nowUTC.getDayOfMonth();
        if (day < 10) {
            String dayValue = "0" + day;
            return dayValue;
        }
        return String.valueOf(day);
    }

    protected String getCurrentMonth() {
        DateTime now = new DateTime();
        int month = now.getMonthOfYear();
        if (month < 10) {
            String monthValue = "0" + month;
            return monthValue;
        }
        return String.valueOf(month);
    }

    protected String getCurrentYear() {
        DateTime now = new DateTime();
        return now.getYear() + "";
    }

    protected String getCurrentDay() {
        return getCurrentDate() + "/" + getCurrentMonth() + "/" + getCurrentYear();
    }
}
