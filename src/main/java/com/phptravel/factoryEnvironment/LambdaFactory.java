package com.phptravel.factoryEnvironment;

import com.phptravel.commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class LambdaFactory {
    private WebDriver driver;
    private String browserName;
    private String osName;

    public LambdaFactory(String browserName, String osName) {

        this.browserName = browserName;
        this.osName = osName;
    }

    public WebDriver creatDriver() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platformName", osName);
        capability.setCapability("browserName", browserName);
        capability.setCapability("browserVersion", "latest");
        capability.setCapability("video", true);
        capability.setCapability("visual", true);

        if (osName.contains("Windows")) {
            capability.setCapability("screenResolution", "1920x1080");
        } else {
            capability.setCapability("screenResolution", "1920x1440");
        }
        capability.setCapability("sauce:options", capability);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.getGlobalConstants().getSaucelabUrl()), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
