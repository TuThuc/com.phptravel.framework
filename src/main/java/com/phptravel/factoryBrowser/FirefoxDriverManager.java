package com.phptravel.factoryBrowser;

import com.phptravel.commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FirefoxDriverManager implements BrowserFactory {

        @Override
        public WebDriver getBrowserDriver() {
            FirefoxOptions options = new FirefoxOptions();
            FirefoxProfile profile = new FirefoxProfile();
            options.setProfile(profile);
            //System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            // System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.getGlobalConstants().getBrowserLogs());
            options.addPreference("intl.accept_languages", "vi-vn, vi, en-us, en");
            options.setAcceptInsecureCerts(true);
            return new FirefoxDriver(options);
        }
        }
