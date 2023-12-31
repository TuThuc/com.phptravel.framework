package com.phptravel.factoryEnvironment;

import com.phptravel.commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackFactory {
    private WebDriver driver;
    private String browserName;
    private String osName;
    private String osVersion;

    public BrowserstackFactory(String browserName, String osName, String osVersion) {
        this.browserName = browserName;
        this.osName = osName;
        this.osVersion = osVersion;
    }

    public WebDriver creatDriver() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("os", osName);
        capability.setCapability("os_version", osVersion);
        capability.setCapability("browser", browserName);
        capability.setCapability("browser_version", "latest");
        capability.setCapability("browser.debug", "true");
        capability.setCapability("projectName", "NopCommerce");
        capability.setCapability("resolution", "1920x1080");
        capability.setCapability("name", "Run on" + osName + " | " + osVersion + " | " + browserName);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.getGlobalConstants().getBrowserStackUrl()), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;

    }
}
