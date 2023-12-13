package com.phptravel.factoryEnvironment;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import com.phptravel.commons.GlobalConstants;
import com.phptravel.factoryBrowser.BrowserList;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridFactory {
    private String browserName;
    private String ipAddress;
    private String portNumber;
    private WebDriver driver;

    public GridFactory(String browserName, String ipAddress, String portNumber) {
        this.browserName = browserName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }

    public WebDriver creatDriver() {
        DesiredCapabilities capability = null;
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        if (browserList == BrowserList.FIREFOX) {
           DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("firefox");
            capabilities.setPlatform(Platform.ANY);
            FirefoxOptions options = new FirefoxOptions();
            FirefoxProfile profile = new FirefoxProfile();
            options.setProfile(profile);
            options.merge(capability);
        } else if (browserList == BrowserList.H_FIREFOX) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("window-size = 1920x1080");
            driver = new FirefoxDriver(options);
        } else if (browserList == BrowserList.CHROME) {
            ChromeOptions options = new ChromeOptions();
            options.addExtensions(new File(GlobalConstants.getGlobalConstants().getExtensionPath()+ "adblocker_ultimate.crx"));
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capability.setBrowserName("chrome");
            capability.setPlatform(Platform.ANY);
            options.merge(capability);
        } else if (browserList == BrowserList.H_CHROME) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size = 1920x1080");
            driver = new ChromeDriver(options);
        } else if (browserList == BrowserList.EDGE_CHROMIUM) {
            driver = new EdgeDriver();
        } else if (browserList == BrowserList.EDGE_LEGACY) {
            driver = new EdgeDriver();

        } else if (browserList == BrowserList.IE) {
            driver = new InternetExplorerDriver();
        } else if (browserList == BrowserList.COCCOC) {
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\Admin\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
            driver = new ChromeDriver(options);

        } else if (browserList == BrowserList.BRAVE) {
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
            driver = new ChromeDriver(options);
        } else {
            throw new RuntimeException("Brower name invalid");
        }
        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}