package com.phptravel.testcases;

import com.aventstack.extentreports.Status;
import com.phptravel.commons.BaseTest;
import com.phptravel.commons.PageGeneratorManager;
import com.phptravel.pageObjects.HomePageObject;
import com.phptravel.pageObjects.LoginPageObject;
import com.phptravel.pageObjects.RegisterPageObject;
import com.phptravel.reportConfig.ExtentManager;
import com.phptravel.ultilities.excelultils.ExcelUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class Register extends BaseTest {
    @Parameters({"envName", "browserName", "serverName", "ipAddress", "portNumnber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion,
                            @Optional("localhost") String ipAddress, @Optional("4444") String portNumber){
        this.browserName = browserName;
        driver = getBrowserDriver(envName, browserName, serverName, ipAddress, portNumber, osName, osVersion);
        ExcelUtil.setExcelFileSheet("RegisterData");
    homePage = PageGeneratorManager.getHomePage(driver);
}
@Test
public void Register_01_RegisterWithDataEmpty(Method method){
    ExtentManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(), "TC_01 :Check_Fields_Required");
    ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 01: Click to 'Account link'");
    homePage.clickToAccountLink();

    ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 02: Click to 'Signup link'");
    registerPage = homePage.clickToSignupLink();

    ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 03: Input to 'Firt Name' textbox");
    registerPage.inputToFirstNameTextbox(ExcelUtil.getCellData(1,1).toString());

    ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 04: Input to 'Last Name' textbox");
    registerPage.inputToLastNameTextbox(ExcelUtil.getCellData(1,2).toString());

    ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 05: Input to 'Phone' textbox");
    registerPage.inputToPhoneTextbox(ExcelUtil.getCellData(1,3).toString());

    ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 06: Input to 'Email' textbox");
    registerPage.inputToEmailTextbox(ExcelUtil.getCellData(1,4).toString());

    ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 07: Input to 'Password' textbox");
    registerPage.inputToPasswordTextbox(ExcelUtil.getCellData(1,5).toString());

    ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 08: Click to 'Captchar' checkbox");
    registerPage.clicktoCaptcharCheckbox();

    ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 09: Click to 'Signup' button");
    registerPage.clicktoSignupButton();

    ExtentManager.getTest().log(Status.INFO, "TC_01 - Step 10: Verify firstName error displayed");
    verifyEquals(registerPage.getFirstnameEmptyError(),ExcelUtil.getCellData(1,6));

    registerPage.saveTestResult(1,7);












}
@AfterClass(alwaysRun = true)
public void afterClass(){
        closeBrowserAndDriver();
}
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private String browserName;
}
