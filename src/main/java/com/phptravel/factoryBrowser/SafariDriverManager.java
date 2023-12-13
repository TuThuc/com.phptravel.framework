package com.phptravel.factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariDriverManager implements BrowserFactory{

    @Override
    public WebDriver getBrowserDriver() {
        SafariOptions options = new SafariOptions();
        options.setCapability("safari.cleanSession", true);
        return  new SafariDriver(options);

    }
}
