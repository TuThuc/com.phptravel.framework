package com.phptravel.testcases;

import com.phptravel.commons.BaseTest;
import com.phptravel.commons.PageGeneratorManager;
import com.phptravel.pageObjects.HomePageObject;
import com.phptravel.pageObjects.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Register extends BaseTest {
    @Parameters({"envName", "serverName", "browserName", "ipAddress", "port", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("Windows") String osName, @Optional("10") String osVersion,
                            @Optional("localhost") String ipAddress, @Optional("4444") String portNumber){
    driver = getBrowserDriver(envName, browserName, envName, ipAddress, portNumber, osName, osVersion);

    homePage = PageGeneratorManager.getHomePage(driver);

}
@Test
public void Register_01_RegisterWithDataEmpty(){
System.out.println("test");
}
@AfterClass
public void afterClass(){
        closeBrowserAndDriver();
}
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
}
